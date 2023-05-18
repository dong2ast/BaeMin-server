package sopt.org.cds.controller.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.cds.controller.cart.dto.request.CartItemRequestDto;
import sopt.org.cds.controller.cart.dto.response.CartItemResponseDto;
import sopt.org.cds.controller.cart.dto.response.CartResponseDto;
import sopt.org.cds.service.CartService;

@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/cart/{cartId}")
    @ResponseStatus(HttpStatus.OK)
    public CartResponseDto getCartById(@PathVariable final Long cartId) {
        return cartService.getCart(cartId);
    }

    @PostMapping("/cart")
    @ResponseStatus(HttpStatus.OK)
    public CartItemResponseDto addCartItem(@RequestBody final CartItemRequestDto requestDto) {
        return cartService.addCartItem(requestDto);
    }

    @DeleteMapping("/cart/{cartItemId}")
    @ResponseStatus(HttpStatus.OK)
    public Long deleteCartItem(@PathVariable final Long cartItemId) {
        return cartService.deleteCartItem(cartItemId);
    }
}
