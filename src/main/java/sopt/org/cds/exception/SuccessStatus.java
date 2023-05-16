package sopt.org.cds.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    GETSTORELIST_SUCCESS(HttpStatus.OK, "가게목록을 성공적으로 불러왔습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
