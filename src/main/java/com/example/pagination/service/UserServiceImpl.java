package com.example.pagination.service;

import com.example.pagination.dto.user.UserRegistrationRequest;
import com.example.pagination.dto.user.UserResponseDto;
import com.example.pagination.exception.RegistrationException;
import com.example.pagination.mapper.UserMapper;
import com.example.pagination.model.User;
import com.example.pagination.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(UserRegistrationRequest request) throws RegistrationException {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RegistrationException("User already exists");
        }
        User user = new User();
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
}
