package com.example.crud.controller;

import com.example.crud.dto.LoginRequestDto;
import com.example.crud.dto.SignupRequestDto;
import com.example.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public String signUp(SignupRequestDto requestDto) {
        return userService.signUp(requestDto);
    }

    @PostMapping("/login")
    public String login(LoginRequestDto requestDto) {
        return userService.login(requestDto);
    }
}
/*
@Controller

 @PostMapping("/signup")
    public String signup(SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return "redirect:/api/user/login";
    }

    @PostMapping("/login")
    public String login(LoginRequestDto loginRequestDto) {
        userService.login(loginRequestDto);
        return "redirect:/api/shop";
    }
 */