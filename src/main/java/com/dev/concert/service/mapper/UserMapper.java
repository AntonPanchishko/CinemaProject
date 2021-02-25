package com.dev.concert.service.mapper;

import com.dev.concert.model.User;
import com.dev.concert.model.dto.response.UserResponseDto;
import com.dev.concert.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import com.dev.concert.model.User;
import com.dev.concert.model.dto.response.UserResponseDto;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final RoleService roleService;

    @Autowired
    public UserMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    public UserResponseDto toDtoFromObject(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
