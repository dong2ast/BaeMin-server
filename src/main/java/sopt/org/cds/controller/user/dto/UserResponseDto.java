package sopt.org.cds.controller.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {
    private final String address;

    public static UserResponseDto of(String address) {
        return new UserResponseDto(address);
    }
}
