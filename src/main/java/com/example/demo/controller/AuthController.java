package com.example.demo.controller;

import com.example.demo.dto.request.SignInReqeust;
import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.SignInResponse;
import com.example.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/sign-up")
    public void signUp(@RequestBody UserRequest req){
        authService.signUp(req);
    }

    // 받아올 것 username, password
    // response userId, userNickname
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/sign-in")
    public SignInResponse signIn(@RequestBody SignInReqeust req){
        return authService.signIn(req);
    }


}
