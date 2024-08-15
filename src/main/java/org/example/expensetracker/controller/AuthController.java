package org.example.expensetracker.controller;

import lombok.RequiredArgsConstructor;
import org.example.expensetracker.request.LoginRequest;
import org.example.expensetracker.request.RegisterRequest;
import org.example.expensetracker.response.AuthResponse;
import org.example.expensetracker.response.GeneralResponse;
import org.example.expensetracker.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse auth(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public GeneralResponse auth(@RequestBody RegisterRequest request) {
        authService.register(request);
        return GeneralResponse.builder()
                .message("User successfully registered")
                .build();
    }
}
