package sopt.org.cds.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.cds.common.dto.ApiResponseDto;
import sopt.org.cds.controller.user.dto.UserResponseDto;
import sopt.org.cds.exception.SuccessStatus;
import sopt.org.cds.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("user")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<UserResponseDto> getUserInfo(@RequestHeader String authorization) {
        UserResponseDto response = userService.authentication(authorization);
        return ApiResponseDto.success(SuccessStatus.GET_USER_SUCCESS, response);
    }
}
