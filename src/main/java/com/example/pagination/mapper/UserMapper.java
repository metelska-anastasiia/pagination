package com.example.pagination.mapper;

import com.example.pagination.config.MapperConfig;
import com.example.pagination.dto.user.UserRegistrationRequest;
import com.example.pagination.dto.user.UserResponseDto;
import com.example.pagination.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    User toModel(UserRegistrationRequest request);
}
