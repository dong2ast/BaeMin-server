package sopt.org.cds.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import sopt.org.cds.controller.user.dto.UserResponseDto;
import sopt.org.cds.domain.User;
import sopt.org.cds.infrastructure.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto authentication(String token) {

        String[] split = token.split(" ");
        String credential = split[1];

        String decoded = new String(Base64Utils.decodeFromString(credential));

        String[] userIdAndAddress = decoded.split(":");
        Long userId = Long.parseLong(userIdAndAddress[0]);

        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return UserResponseDto.of(user.get().getAddress());
        } else {
            throw new RuntimeException();
        }

    }
}
