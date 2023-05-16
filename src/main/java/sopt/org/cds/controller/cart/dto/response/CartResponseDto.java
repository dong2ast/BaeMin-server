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
    private List<CartStoreDto> cartStoreDtoList;

    public static CartResponseDto of(Long cartId, List<CartStoreDto> cartStoreDtoList){
        return new CartResponseDto(cartId, cartStoreDtoList);
    }
}
