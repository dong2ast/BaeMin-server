package sopt.org.cds.controller.cart.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CartItemResponseDto {
    private Long cartItemId;
    private String name;
    private Integer Price;
    private Integer count;

    public static CartItemResponseDto of(Long cartItemId, String name, Integer totalPrice, Integer count) {
        return new CartItemResponseDto(cartItemId, name, totalPrice, count);
    }
}
