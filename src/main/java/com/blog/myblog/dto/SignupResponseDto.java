package com.blog.myblog.dto;

import com.blog.myblog.domain.Users;
import lombok.Getter;

@Getter
public class SignupResponseDto {
    private Long id;
    private String username;
    public SignupResponseDto(Users users){
        this.id = users.getId();
        this.username = users.getUsername();
    }
}
