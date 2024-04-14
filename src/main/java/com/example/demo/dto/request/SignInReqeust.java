package com.example.demo.dto.request;

import com.example.demo.domain.User;

public record SignInReqeust(String name, String password) {
    public User toEntity(){
        return User.builder().name(name).password(password).build();
    }
}

