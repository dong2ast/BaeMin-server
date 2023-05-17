package sopt.org.cds.common.advice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import sopt.org.cds.common.dto.ApiResponseDto;
import sopt.org.cds.exception.ErrorStatus;

import static sopt.org.cds.common.dto.ApiResponseDto.error;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return error(ErrorStatus.VALIDATION_REQUEST_MISSING_EXCEPTION);
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
