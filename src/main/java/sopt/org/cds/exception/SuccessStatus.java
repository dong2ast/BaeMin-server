package sopt.org.cds.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    GET_USER_SUCCESS(HttpStatus.OK, "사용자 정보를 성공적으로 불러왔습니다"),
    GET_STORE_LIST_SUCCESS(HttpStatus.OK, "가게 리스트를 성공적으로 불러왔습니다."),
    GET_STORE_DETAIL_SUCCESS(HttpStatus.OK, "가게 정보를 성공적으로 불러왔습니다."),
    GET_MENU_DETAIL_SUCCESS(HttpStatus.OK, "메뉴 정보를 성공적으로 불러왔습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
