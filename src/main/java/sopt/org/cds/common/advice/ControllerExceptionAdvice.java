package sopt.org.cds.common.advice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import sopt.org.cds.common.dto.ApiResponseDto;
import sopt.org.cds.exception.*;

import static sopt.org.cds.common.dto.ApiResponseDto.error;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return error(ErrorStatus.VALIDATION_REQUEST_MISSING_EXCEPTION);
    }

    // Cart 조회 실패
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCartException.class)
    protected ApiResponseDto handleInvalidCartException(final InvalidCartException e) {
        return error(ErrorStatus.VALIDATION_INVALID_CART_EXCEPTION);
    }

    // CartItem 조회 실패
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCartItemException.class)
    protected ApiResponseDto handleInvalidCartItemException(final InvalidCartItemException e) {
        return error(ErrorStatus.VALIDATION_INVALID_CART_ITEM_EXCEPTION);
    }

    // Store 조회 실패
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundStoreException.class)
    protected ApiResponseDto handleNotFoundStoreException(final NotFoundStoreException e) {
        return error(ErrorStatus.NOT_FOUND_STORE_EXCEPTION);
    }

    // Menu 조회 실패
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundMenuException.class)
    protected ApiResponseDto handleNotFoundMenuException(final NotFoundMenuException e) {
        return error(ErrorStatus.NOT_FOUND_STORE_EXCEPTION);
    }

    // 유효하지 않은 토큰
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidTokenException.class)
    protected ApiResponseDto handleNotFoundMenuException(final InvalidTokenException e) {
        return error(ErrorStatus.INVALID_TOKEN_EXCEPTION);
    }

    // 존재하지 않는 유저
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundUserException.class)
    protected ApiResponseDto handleNotFoundUserException(final NotFoundUserException e) {
        return error(ErrorStatus.NOT_FOUND_USER_EXCEPTION);
    }


    @ExceptionHandler(HttpServerErrorException.class)
    protected ApiResponseDto handleServerErrorException(final HttpServerErrorException e) {
        return error(e.getStatusCode(), e.getMessage());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    protected ApiResponseDto handleClientErrorException(final HttpClientErrorException e) {
        return error(e.getStatusCode(), e.getMessage());
    }


}
