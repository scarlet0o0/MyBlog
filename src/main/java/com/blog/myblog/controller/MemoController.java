package com.blog.myblog.controller;

import com.blog.myblog.dto.MemoListResponseDto;
import com.blog.myblog.dto.MemoRequestDto;
import com.blog.myblog.dto.MemoResponseDto;
import com.blog.myblog.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoService memoService;

    //글 목록을 불러옴
    @GetMapping("/api/memos")
    public ResponseEntity<MemoListResponseDto> getMemos() {

        MemoListResponseDto memoResponseDto = memoService.readAll();
        return ResponseEntity.ok()
                .body(memoResponseDto);
    }

    //글 하나를 불러옴
    @GetMapping("/api/memo/{id}")
    public ResponseEntity<MemoResponseDto> getMemo(@PathVariable Long id) {
        MemoResponseDto memoResponseDto = memoService.read(id);
        return ResponseEntity.ok()
                .body(memoResponseDto);
    }

    //글을 작성
    @PostMapping("/api/memo")
    public ResponseEntity<MemoResponseDto> createMemo(@RequestBody MemoRequestDto memoRequestDto) {
        MemoResponseDto memoResponseDto = memoService.write(memoRequestDto);

        return ResponseEntity.ok()
                .body(memoResponseDto);
    }

    //글을 수정
    @PutMapping("/api/memo/{id}")
    public ResponseEntity<MemoResponseDto> updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto) {
        MemoResponseDto memoResponseDto = memoService.edit(id, memoRequestDto);

        return ResponseEntity.ok()
                .body(memoResponseDto);
    }

    //글을 삭제
    @DeleteMapping("/api/memo/{id}")
    public ResponseEntity<Boolean> deleteMemo(@PathVariable Long id) {
        Boolean isDelete = memoService.delete(id);

        return ResponseEntity.ok()
                .body(isDelete);
    }

    //글 목록을 불러옴







}
