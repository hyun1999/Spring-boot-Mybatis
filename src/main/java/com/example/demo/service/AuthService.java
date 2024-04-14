package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.request.SignInReqeust;
import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.SignInResponse;
import com.example.demo.exception.ExistUsernameException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserMapper userMapper;

    public void signUp(UserRequest req){
        List<User> byUserName = userMapper.findByUserName(req.name());
        if(!byUserName.isEmpty()){
            throw new ExistUsernameException();
        }
        userMapper.addUser(req.toEntity());
    }

    public SignInResponse signIn(SignInReqeust req){
        User byUserName = userMapper.findByUserName(req.name()).get(0);
        if(byUserName == null) throw new UserNotFoundException("Login Fail");

        if(!byUserName.getPassword().equals(req.password())){
            throw new UserNotFoundException("Login Fail");
        }
        return new SignInResponse(byUserName.getId(),byUserName.getNickname());
    }
}

