package sopt.org.cds.service;


import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import sopt.org.cds.controller.user.dto.UserResponseDto;
import sopt.org.cds.domain.User;
import sopt.org.cds.exception.InvalidTokenException;
import sopt.org.cds.exception.NotFoundUserException;
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
        String payload = credential.split("\\.")[1];
        String decode = new String(Base64Utils.decodeFromString(payload));

        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(decode);
            Long userId = (Long) jsonObject.get("id");
            Optional<User> user = userRepository.findById(userId);

            if (user.isPresent()) {
                return UserResponseDto.of(user.get().getAddress());
            } else {
                throw new NotFoundUserException();
            }
        } catch (ParseException e) {
            throw new InvalidTokenException();
        }

    }
}
