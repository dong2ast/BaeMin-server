package sopt.org.cds.controller.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.cds.common.dto.ApiResponseDto;
import sopt.org.cds.controller.cart.dto.request.CartItemRequestDto;
import sopt.org.cds.controller.cart.dto.request.CountRequestDto;
import sopt.org.cds.controller.cart.dto.response.CartItemResponseDto;
import sopt.org.cds.controller.cart.dto.response.CartResponseDto;
import sopt.org.cds.service.CartService;

import static sopt.org.cds.exception.SuccessStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping("/{cartId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<CartResponseDto> getCartById(@PathVariable final Long cartId) {
        return ApiResponseDto.success(GET_CART_SUCCESS, cartService.getCart(cartId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<CartItemResponseDto> addCartItem(@RequestBody final CartItemRequestDto requestDto) {
        return ApiResponseDto.success(CREATE_ITEM_SUCCESS, cartService.addCartItem(requestDto));
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<CartItemResponseDto> patchCartItem(@RequestBody final CountRequestDto requestDto) {
        return ApiResponseDto.success(CHANGE_COUNT_SUCCESS, cartService.patchCartItem(requestDto.getCartItemId(), requestDto.getCount()));
    }

    @DeleteMapping("/{cartItemId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<CartItemResponseDto> deleteCartItem(@PathVariable final Long cartItemId) {
        return ApiResponseDto.success(DELETE_ITEM_SUCCESS, cartService.deleteCartItem(cartItemId));
    }
}
