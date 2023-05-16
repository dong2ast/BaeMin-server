package sopt.org.cds.controller.cart.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CartRequestDto {
    @NotNull
    private Long userId;

    @NotNull
    private Long cartId;

    @NotNull
    private Long storeId;
}
