package com.blog.myblog.controller;

import com.blog.myblog.domain.*;
import com.blog.myblog.service.MemoService;
import com.blog.myblog.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;
    private final ResponseService responseService;

    @PostMapping("/api/memo")
    public SingleResponse<Memo> createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memo = memoRepository.save(memo);
        return responseService.getSingleResponse(memo);
    }

    @GetMapping("/api/memos")
    public ListResponse getMemos() {
        List<Memo> memoList = memoRepository.findAllByOrderByModifiedAtDesc();
        return responseService.getListResponse(memoList);
    }

    @GetMapping("/api/memo/{id}")
    public SingleResponse<Memo> getMemo(@PathVariable Long id) {
        Memo memo = memoService.findId(id);
        return responseService.getSingleResponse(memo);
    }

    @PostMapping("/api/memo/{id}")
    public SingleResponse<Boolean> isMemoPassword(@PathVariable Long id,@RequestBody MemoRequestDto requestDto){
        Boolean isPassword = memoService.isPassword(id,requestDto.getPassword());
        return responseService.getSingleResponse(isPassword);
    }

    @PutMapping("/api/memo/{id}")
    public SingleResponse<Memo> updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        Memo memo = memoService.update(id, requestDto);
        return responseService.getSingleResponse(memo);
    }

    @DeleteMapping("/api/memo/{id}")
    public SingleResponse<Boolean> deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return responseService.getSingleResponse(true);
    }
}
