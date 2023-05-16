package sopt.org.cds.controller.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.cds.controller.cart.dto.response.CartResponseDto;
import sopt.org.cds.infrastructure.CartRepository;
import sopt.org.cds.service.CartService;

@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartRepository cartRepository;

//    @GetMapping("/{userId}")
//    @ResponseStatus(HttpStatus.OK)
//    public ApiResponseDto<OnePostResponseDto> getCartById(@PathVariable final Long userId) {
//        return ApiResponseDto.success(SuccessStatus.LOADINGPOST_SUCCESS, CartService.(postId));
//    }

    @GetMapping("/cart/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public CartResponseDto getCartById(@PathVariable final Long userId) {
        return cartService.getCart(userId);
    }
}
