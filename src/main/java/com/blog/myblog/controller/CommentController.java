package com.blog.myblog.controller;

import com.blog.myblog.dto.CommentRequestDto;
import com.blog.myblog.dto.CommentResponseDto;
import com.blog.myblog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    //댓글을 작성 함
    @PostMapping("/api/comment/")
    public ResponseEntity<CommentResponseDto> getComment(@RequestBody CommentRequestDto commentRequestDto) {
        CommentResponseDto commentResponseDto = commentService.write(commentRequestDto);
        return ResponseEntity.ok()
                .body(commentResponseDto);
    }

//    @GetMapping("/api/comment/{id}")
//    public

    @PutMapping("/api/comment/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable Long id,@RequestBody CommentRequestDto commentRequestDto) {
        CommentResponseDto commentResponseDto = commentService.edit(id, commentRequestDto);
        return ResponseEntity.ok()
                .body(commentResponseDto);
    }

    @DeleteMapping("/api/comment/{id}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable Long id) {
        Boolean isDeleteComment = commentService.delete(id);
        return ResponseEntity.ok()
                .body(isDeleteComment);
    }
}
