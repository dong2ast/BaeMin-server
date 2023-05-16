package sopt.org.cds.controller.cart.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CartItemRequestDto {

    private Long cartId;

    private Long storeId; //조회해서 cartstore가 있으면 item추가, 없으면 cartstore 생성

    private String name;

    private Integer totalPrice;

    private String options;

    private Integer count;
}
