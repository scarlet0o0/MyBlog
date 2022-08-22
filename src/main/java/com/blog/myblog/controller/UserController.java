package com.blog.myblog.controller;

import com.blog.myblog.domain.SingleResponse;
import com.blog.myblog.domain.Users;
import com.blog.myblog.dto.SignupRequestDto;
import com.blog.myblog.dto.SignupResponseDto;
import com.blog.myblog.service.ResponseService;
import com.blog.myblog.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    private final ResponseService responseService;

    public UserController(UserService userService, ResponseService responseService) {
        this.userService = userService;
        this.responseService = responseService;
    }

    // 회원 로그인 페이지
//    @GetMapping("/user/login")
//    public String login() {
//        return "login";
//    }
//
//    // 회원 가입 페이지
//    @GetMapping("/user/signup")
//    public String signup() {
//        return "signup";
//    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public SingleResponse<SignupResponseDto> registerUser(@RequestBody SignupRequestDto requestDto) {
        Users users = userService.registerUser(requestDto);
        SignupResponseDto signupResponseDto = new SignupResponseDto(users);
        return responseService.getSingleResponse(signupResponseDto);
    }
}