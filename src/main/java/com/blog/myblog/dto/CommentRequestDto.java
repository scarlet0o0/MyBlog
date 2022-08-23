package com.blog.myblog.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long memoId;
    private String username;
    private String contents;

}
