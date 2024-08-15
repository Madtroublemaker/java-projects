package org.example.expensetracker.service;

import lombok.RequiredArgsConstructor;
import org.example.expensetracker.enums.Role;
import org.example.expensetracker.mapper.UserMapper;
import org.example.expensetracker.model.User;
import org.example.expensetracker.request.LoginRequest;
import org.example.expensetracker.request.RegisterRequest;
import org.example.expensetracker.response.AuthResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final TokenService tokenService;
    private final EncoderService encoderService;
    private final UserMapper userMapper;

    public AuthResponse login(LoginRequest request) {
        return findByUsername(request.getUsername().toLowerCase())
                .map(userMapper::tokenUserFromUser)
                .map(tokenService::generateToken)
                .map(tokenService::authResponseFromToken)
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }

    public void register(RegisterRequest request) {
        findByUsername(request.getUsername().toLowerCase()).ifPresent((e) -> {
            throw new RuntimeException("User with such username already exists!");
        });

        User user = userMapper.fromRegisterRequest(request);
        user.setPassword(encoderService.encode(request.getPassword()));
        user.setUsername(request.getUsername().toLowerCase());
        user.setRole(Role.ROLE_USER);

        userService.save(user);
    }

    private Optional<User> findByUsername(String username) {
        return userService.findByUsername(username);
    }
}
