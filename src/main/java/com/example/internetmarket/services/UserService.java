package com.example.internetmarket.services;

import com.example.internetmarket.dto.JwtResponseDto;
import com.example.internetmarket.dto.SignInDto;
import com.example.internetmarket.dto.SignUpDto;
import com.example.internetmarket.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails loadUserDetailsByUsername(String username);

    User loadUserByUsername(String username);

    JwtResponseDto authenticate(SignInDto request);

    ResponseEntity<String> signup(SignUpDto request);

    User find(Long id);
}
