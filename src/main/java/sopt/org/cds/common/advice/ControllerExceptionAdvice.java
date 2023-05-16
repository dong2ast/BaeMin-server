package sopt.org.cds.common.advice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
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


}
