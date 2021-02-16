package com.dev.cinema.service.mapper;

import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.request.UserRequestDto;
import com.dev.cinema.model.dto.response.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User fromDtoToObject(UserRequestDto userRequestDto) {
        User user = new User();
        user.setPassword(userRequestDto.getPassword());
        user.setEmail(userRequestDto.getEmail());
        return user;
    }

    public UserResponseDto toDtoFromObject(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
