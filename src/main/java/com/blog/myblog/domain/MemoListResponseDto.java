package com.blog.myblog.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemoListResponseDto {
    private String title;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
