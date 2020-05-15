package com.example.internetmarket.services;

import com.example.internetmarket.configuration.UserPrinciple;
import com.example.internetmarket.configuration.security.JwtProvider;
import com.example.internetmarket.dto.JwtResponseDto;
import com.example.internetmarket.dto.SignInDto;
import com.example.internetmarket.dto.SignUpDto;
import com.example.internetmarket.enums.RoleName;
import com.example.internetmarket.models.User;
import com.example.internetmarket.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    private final UserRepository repository;

    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserDetailsByUsername(final String username) {
        return UserPrinciple.build(loadUserByUsername(username));
    }

    @Override
    public User loadUserByUsername(final String username) {
        return repository.findByUsername(username);
    }

    @Override
    public JwtResponseDto authenticate(final SignInDto request) {
        final User user = loadUserByUsername(request.getUsername());

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String jwt = jwtProvider.generateJwtToken(authentication);
        return JwtResponseDto.builder()
                .id(((UserPrinciple) authentication.getPrincipal()).getId())
                .token(jwt)
                .role(user.getRole().name())
                .username(request.getUsername()).build();
    }

    @Override
    public ResponseEntity<String> signup(final SignUpDto request) {
        if(repository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("Fail -> Username is already taken!");
        }

        if(repository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body("Fail -> Email is already in use!");
        }

        final User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .username(request.getUsername())
                .role(RoleName.USER)
                .password(encoder.encode(request.getPassword())).build();

        repository.save(user);
        return ResponseEntity.ok().body("User registered successfully!");
    }

    @Override
    public User find(final Long id) {
        return repository.getOne(id);
    }
}
