package sopt.org.cds.controller.cart.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CartStoreDto {
    private Long cartStoreId;
    private String name;
    private String image;
    private List<CartItemDto> cartItemDtoList;

    public static CartStoreDto of(Long cartStoreId, String name, String image, List<CartItemDto> cartItemDtoList) {
        return new CartStoreDto(cartStoreId, name, image, cartItemDtoList);
    }
}
