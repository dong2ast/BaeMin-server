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
import sopt.org.cds.infrastructure.CartItemRepository;
import sopt.org.cds.infrastructure.CartRepository;
import sopt.org.cds.infrastructure.CartStoreRepository;
import sopt.org.cds.infrastructure.StoreRepository;

import java.util.ArrayList;
import java.util.List;

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
    public CartResponseDto getCart(Long cartId) { //uid만 쓰는거면 dto 안써도 될 것 같은데,
//        User user = userRepository.findOne(userId);
//        Cart cart = user.getCart();
        Cart cart = cartRepository.findOne(cartId);
        List<CartStoreDto> cartStoreDtoList = new ArrayList<>();

        cart.getCartStoreList().stream().forEach(cartStore -> {
            List<CartItemDto> cartItemDtoList = new ArrayList<>();
            cartStore.getCartItems().stream().forEach(cartItem -> {
                cartItemDtoList.add(CartItemDto.of(cartItem.getName(), cartItem.getTotalPrice(), cartItem.getOptions(), cartItem.getCount()));
            });
            cartStoreDtoList.add(CartStoreDto.of(cartStore.getStore().getName(), cartStore.getStore().getImage(), cartItemDtoList));
        });
        return CartResponseDto.of(cart.getId(), cartStoreDtoList);
    }

    /*
        CartItem을 추가하는 메서드 (장바구니 담기) [Post]
        CartStore객체를 해당 메서드 내에서 생성됨 (CartItem의 storeId를 가진 CartStore 객체가 없을 경우)
     */
    @Transactional
    public CartItemResponseDto addCartItem(CartItemRequestDto requestDto) {
        try {
            CartStore cartStore = cartStoreRepository.findOne(requestDto.getStoreId());
            CartItem cartItem = createCartItem(requestDto, cartStore);
            return CartItemResponseDto.of(cartItem.getId(), cartItem.getName(), cartItem.getTotalPrice(), cartItem.getCount());
        } catch (NullPointerException e) { //cartStore가 없는 경우 cartStore를 만들고 cartItem 생성
            CartStore cartStore = createCartStore(requestDto);
            CartItem cartItem = createCartItem(requestDto, cartStore);
            return CartItemResponseDto.of(cartItem.getId(), cartItem.getName(), cartItem.getTotalPrice(), cartItem.getCount());
        }
    }

    private CartStore createCartStore(CartItemRequestDto requestDto) {
        Store store = storeRepository.findById(requestDto.getStoreId());
        Cart cart = cartRepository.findOne(requestDto.getCartId());
        CartStore cartStore = CartStore.createCart(store, cart);
        cartStoreRepository.save(cartStore);
        return cartStore;
    }

    private CartItem createCartItem(CartItemRequestDto requestDto, CartStore cartStore) {
        CartItem cartItem = CartItem.createCartItem(requestDto.getName(), requestDto.getTotalPrice(), requestDto.getOptions(), requestDto.getCount(), cartStore);
        cartItemRepository.save(cartItem);
        return cartItem;
    }
}
