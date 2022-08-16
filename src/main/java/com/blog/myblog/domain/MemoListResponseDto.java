package com.blog.myblog.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemoListResponseDto {
    private String title;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    MemoListResponseDto(Memo memo){
        this.title = memo.getTitle();
        this.username = memo.getUsername();
        this.createdAt = memo.getCreatedAt();
        this.modifiedAt = memo.getModifiedAt();
    }
}
