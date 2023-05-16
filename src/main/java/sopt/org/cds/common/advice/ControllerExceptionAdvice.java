package sopt.org.cds.common.advice;

import ch.qos.logback.core.status.ErrorStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt.org.cds.common.dto.ApiResponseDto;

@RestControllerAdvice
public class ControllerExceptionAdvice {
//    [Template]
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class) //해당 exception이 발생하면 아래 메서드 처리
//    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
//        return ApiResponseDto.error(ErrorStatus.?);
//    }


}
