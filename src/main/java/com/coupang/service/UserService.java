package com.coupang.service;

import com.coupang.datamodel.dto.UserDTO;
import com.coupang.model.User;
import com.coupang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO userById(String userId) throws Exception{
        return new UserDTO(this.userRepository.findById(userId)
                .orElseThrow(()-> new Exception("해당유저아이디에 유저가 없습니다")));
    }

    public void initialize() {
        User user1 = User.builder()
                .userId("park")
                .phoneNumber("010-0000-0000")
                .email("example@example.com")
                .gender("남")
                .build();

        User user2 = User.builder()
                .userId("gun")
                .phoneNumber("010-1234-0000")
                .email("example@example.com")
                .gender("여")
                .build();

        User user3 = User.builder()
                .userId("woo")
                .phoneNumber("010-0000-1234")
                .email("example@example.com")
                .gender("남")
                .build();

        this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.userRepository.save(user3);
        this.userRepository.flush();
    }
}
