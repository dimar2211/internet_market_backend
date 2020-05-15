package com.example.internetmarket.controllers;

import com.example.internetmarket.dto.JwtResponseDto;
import com.example.internetmarket.dto.SignInDto;
import com.example.internetmarket.dto.SignUpDto;
import com.example.internetmarket.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("signin")
    public JwtResponseDto authenticateUser(@Valid @RequestBody SignInDto loginRequest) {
        return userService.authenticate(loginRequest);
    }

    @PostMapping("signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpDto signUpRequest) {
        return userService.signup(signUpRequest);
    }
}
