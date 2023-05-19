package sopt.org.cds.controller.cart.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CartItemDto {

    private Long cartItemId;

    private String name;

    private int totalPrice;

    private String options;

    private int count;

    public static CartItemDto of(Long cartItemId, String name, Integer totalPrice, String options, Integer count) {
        return new CartItemDto(cartItemId, name, totalPrice, options, count);
    }
}
