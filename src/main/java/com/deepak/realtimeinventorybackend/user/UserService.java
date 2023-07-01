package com.deepak.realtimeinventorybackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponseDto addUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setUsername(userCreateDto.getUserName());
        user.setPassword(userCreateDto.getPassword());

        User savedUser = userRepository.save(user);
        UserResponseDto responseDto = new UserResponseDto();

        responseDto.setUserName(savedUser.getUsername());
        responseDto.setPassword(savedUser.getPassword());
        return responseDto;

    }

}


