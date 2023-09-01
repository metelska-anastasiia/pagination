package com.example.pagination.service;

import com.example.pagination.dto.user.UserRegistrationRequest;
import com.example.pagination.dto.user.UserResponseDto;
import com.example.pagination.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequest request) throws RegistrationException;
}
