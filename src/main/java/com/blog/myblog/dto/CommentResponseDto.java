package com.blog.myblog.dto;

import com.blog.myblog.domain.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private Long memoId;
    private String username;
    private String contents;

    public CommentResponseDto(Comment comment) {
        this.memoId = comment.getMemoId();
        this.username = comment.getUsername();
        this.contents = comment.getContents();
    }
}
