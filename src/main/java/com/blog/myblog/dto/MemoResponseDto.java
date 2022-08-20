package com.blog.myblog.dto;

import com.blog.myblog.domain.Memo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemoResponseDto {
    private String title;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String contents;

    MemoResponseDto (Memo memo){
        this.title = memo.getTitle();
        this.username = memo.getUsername();
        this.createdAt = memo.getCreatedAt();
        this.modifiedAt = memo.getModifiedAt();
        this.contents = memo.getContents();
    }
}
