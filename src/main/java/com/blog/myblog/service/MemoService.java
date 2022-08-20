package com.blog.myblog.service;

import com.blog.myblog.domain.Memo;
import com.blog.myblog.domain.MemoRepository;
import com.blog.myblog.dto.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Memo update(Long id, MemoRequestDto requestDto) {
        Memo memo = findId(id);
        memo.update(requestDto);
        return memo;
    }

    @Transactional
    public Boolean isPassword(Long id, String password){
        Memo memo = findId(id);
        return password.equals(memo.getPassword());
    }

    @Transactional
    public Memo findId(Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return memo;
    }
}
