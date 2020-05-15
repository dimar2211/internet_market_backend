package com.example.internetmarket.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SignUpDto {

    private String name;

    private String username;

    private String email;

    private String password;
}
