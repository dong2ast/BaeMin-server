package sopt.org.cds.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    GET_CART_SUCCESS(HttpStatus.OK, "장바구니목록을 성공적으로 불러왔습니다"),
    CREATE_ITEM_SUCCESS(HttpStatus.CREATED, "메뉴를 장바구니에 성공적으로 추가하였습니다."),
    DELETE_ITEM_SUCCESS(HttpStatus.OK, "장바구니의 메뉴를 성공적으로 제거하였습니다."),
    CHANGE_COUNT_SUCCESS(HttpStatus.OK, "메뉴의 개수를 성공적으로 변경하였습니다."),
    GET_USER_SUCCESS(HttpStatus.OK, "사용자 정보를 성공적으로 불러왔습니다"),
    GET_STORE_LIST_SUCCESS(HttpStatus.OK, "가게 리스트를 성공적으로 불러왔습니다."),
    GET_STORE_DETAIL_SUCCESS(HttpStatus.OK, "가게 정보를 성공적으로 불러왔습니다."),
    GET_MENU_DETAIL_SUCCESS(HttpStatus.OK, "메뉴 정보를 성공적으로 불러왔습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
