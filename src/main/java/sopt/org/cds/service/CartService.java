package sopt.org.cds.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.cds.controller.cart.dto.CartItemDto;
import sopt.org.cds.controller.cart.dto.CartStoreDto;
import sopt.org.cds.controller.cart.dto.request.CartItemRequestDto;
import sopt.org.cds.controller.cart.dto.response.CartItemResponseDto;
import sopt.org.cds.controller.cart.dto.response.CartResponseDto;
import sopt.org.cds.domain.Cart;
import sopt.org.cds.domain.CartItem;
import sopt.org.cds.domain.CartStore;
import sopt.org.cds.domain.Store;
import sopt.org.cds.exception.InvalidCartException;
import sopt.org.cds.exception.InvalidCartItemException;
import sopt.org.cds.infrastructure.CartItemRepository;
import sopt.org.cds.infrastructure.CartRepository;
import sopt.org.cds.infrastructure.CartStoreRepository;
import sopt.org.cds.infrastructure.StoreRepository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final StoreRepository storeRepository;
    private final CartStoreRepository cartStoreRepository;
    private final CartItemRepository cartItemRepository;

    /*
        카트를 받아오는 메서드 [Get]
        카트를 받아오기 위해 Cart Store와 Cart Item들을 전부 가져와야한다.
        Dto가 3개 사용됨
     */
    public CartResponseDto getCart(Long cartId) throws InvalidCartException { //uid만 쓰는거면 dto 안써도 될 것 같은데,
        try {
            Cart cart = cartRepository.findOne(cartId); //error 가능성
            List<CartStoreDto> cartStoreDtoList = new ArrayList<>();

            cart.getCartStoreList().forEach(cartStore -> {
                List<CartItemDto> cartItemDtoList = new ArrayList<>();
                cartStore.getCartItems().forEach(cartItem -> {
                    cartItemDtoList.add(CartItemDto.of(cartItem.getId(), cartItem.getName(), cartItem.getTotalPrice(), cartItem.getOptions(), cartItem.getCount()));
                });
                cartStoreDtoList.add(CartStoreDto.of(cartStore.getId(), cartStore.getStore().getName(), cartStore.getStore().getImage(), cartItemDtoList));
            });
            return CartResponseDto.of(cart.getId(), cart.getTotalPrice(), cart.getDeliveryFee(), cartStoreDtoList);
        } catch (NullPointerException e) {
            throw new InvalidCartException();
        }
    }

    /*
        CartItem을 추가하는 메서드 (장바구니 담기) [Post]
        CartStore객체는 해당 메서드 내에서 생성됨 (CartItem의 storeId를 가진 CartStore 객체가 없을 경우)
     */
    @Transactional
    public CartItemResponseDto addCartItem(CartItemRequestDto requestDto) throws InvalidCartException {
        try {
            try {
                CartStore cartStore = cartStoreRepository.findOne(requestDto.getStoreId());
                CartItem cartItem = createCartItem(requestDto, cartStore);
                changeCartInfo(requestDto, cartItem);
                return CartItemResponseDto.of(cartItem.getId(), cartItem.getName(), cartItem.getTotalPrice(), cartItem.getCount());
            } catch (NoResultException e) {
                throw new InvalidCartException();
            }
        } catch (NullPointerException e) { //cartStore가 없는 경우 cartStore를 만들고 cartItem 생성
            CartStore cartStore = createCartStore(requestDto);
            CartItem cartItem = createCartItem(requestDto, cartStore);
            changeCartDeliveryFee(requestDto, cartItem); //cartStore가 추가되었을 때 장바구니 총 가격 + 배달팁 변경
            return CartItemResponseDto.of(cartItem.getId(), cartItem.getName(), cartItem.getTotalPrice(), cartItem.getCount());
        }
    }

    //장바구니에 띄워질 총 주문금액 계산 메서드
    private Cart changeCartInfo(CartItemRequestDto requestDto, CartItem cartItem) {
        Cart cart = cartRepository.findOne(requestDto.getCartId());
        cart.changeTotalPrice(cartItem.getTotalPrice());
        return cart;
    }

    //장바구니에 띄워질 총 주문금액 계산 메서드 (cartStore가 추가된 케이스이므로 배달료도 변경)
    private void changeCartDeliveryFee(CartItemRequestDto requestDto, CartItem cartItem) {
        Cart cart = changeCartInfo(requestDto, cartItem);
        Optional<Store> store = storeRepository.findById(requestDto.getStoreId());
        if (store.isPresent()) {
            cart.changeDeliveryFee(store.get().getDeliveryFee()); //store정보로 배달료 변경 (cartStore생성시 변경)
        }
    }

    /*
        장바구니에 store그룹 생성
     */
    private CartStore createCartStore(CartItemRequestDto requestDto) {
        Store store = storeRepository.findById(requestDto.getStoreId()).get();
        Cart cart = cartRepository.findOne(requestDto.getCartId());
        CartStore cartStore = CartStore.createCart(store, cart);
        cartStoreRepository.save(cartStore);
        return cartStore;
    }

    /*
        s
     */
    private CartItem createCartItem(CartItemRequestDto requestDto, CartStore cartStore) {
        CartItem cartItem = CartItem.createCartItem(requestDto.getName(), requestDto.getImage(), requestDto.getTotalPrice(), requestDto.getOptions(), requestDto.getCount(), cartStore);
        cartItemRepository.save(cartItem);
        return cartItem;
    }

    /*
        장바구니 메뉴 변경 메서드 [Patch]
     */
    @Transactional
    public CartItemResponseDto patchCartItem(Long cartItemId, Integer count) throws InvalidCartItemException {
        try {
            CartItem cartItem = cartItemRepository.findbyId(cartItemId);
            cartItem.changeCount(count);
            return CartItemResponseDto.of(cartItemId, cartItem.getName(), cartItem.getTotalPrice(), count);
        } catch (NullPointerException e) {
            throw new InvalidCartItemException();
        }
    }

    /*
        장바구니 메뉴 삭제 메서드 [DELETE]
     */
    @Transactional
    public CartItemResponseDto deleteCartItem(Long cartItemId) throws InvalidCartItemException {
        try {
            CartItem cartItem = cartItemRepository.findbyId(cartItemId);
            cartItemRepository.deleteCartItem(cartItemId);
            return CartItemResponseDto.of(cartItem.getId(), cartItem.getName(), cartItem.getTotalPrice(), cartItem.getCount());
        } catch (NullPointerException e) {
            throw new InvalidCartItemException();
        }
    }
}
