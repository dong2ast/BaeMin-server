package sopt.org.cds.controller.cart.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sopt.org.cds.controller.cart.dto.CartStoreDto;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CartResponseDto {
    private Long cartId;
    private Integer totalPrice;
    private Integer deliveryFee;
    private List<CartStoreDto> cartStoreList;

    public static CartResponseDto of(Long cartId, Integer totalPrice, Integer deliveryFee, List<CartStoreDto> cartStoreList) {
        return new CartResponseDto(cartId, totalPrice, deliveryFee, cartStoreList);
    }
}
