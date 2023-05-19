package sopt.org.cds.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorStatus {

    /*
    BAD_REQUEST
     */
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    VALIDATION_REQUEST_MISSING_EXCEPTION(HttpStatus.BAD_REQUEST, "요청값이 입력되지 않았습니다."),
    VALIDATION_INVALID_CART_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 카트 ID 요청입니다."),
    VALIDATION_INVALID_CART_ITEM_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 카트 ITEM ID 요청입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
