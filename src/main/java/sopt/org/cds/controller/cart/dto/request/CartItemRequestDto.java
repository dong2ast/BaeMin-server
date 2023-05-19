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

    private String image;

    private Integer totalPrice;

    private String options;

    private Integer count;
    //메뉴 id를 받아와서 name image받고 store id까지 받는건?
    //menu id를 받아와서 name과 image storeid까지 받아올까 했었는데 그러면 서버단에서 메뉴 조회를 한번씩 더해야함
    //조회를 줄여야 성능이 향상되므로 이미 있는 데이터는 최대한 활용을 하자
}
