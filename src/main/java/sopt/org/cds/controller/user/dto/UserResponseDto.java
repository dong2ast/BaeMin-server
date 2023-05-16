package sopt.org.cds.controller.user.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserResponseDto {
    private final String nickname;

    public static UserResponseDto of(String address) {
        return new UserResponseDto(address);
    }
}
