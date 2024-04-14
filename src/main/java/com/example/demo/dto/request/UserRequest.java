package com.example.demo.dto.request;

import com.example.demo.domain.User;

public record UserRequest (String name, String password, String nickname){
    public User toEntity(){
        return User.builder().name(name).password(password).nickname(nickname).build();
    }
}
