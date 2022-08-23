package com.blog.myblog.service;

import com.blog.myblog.domain.Memo;
import com.blog.myblog.dto.MemoListResponseDto;
import com.blog.myblog.dto.MemoResponseDto;
import com.blog.myblog.repository.MemoRepository;
import com.blog.myblog.dto.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoListResponseDto readAll(){
        List<Memo> memoList = memoRepository.findAllByOrderByModifiedAtDesc();
        return new MemoListResponseDto(memoList);
    }

    //글을 DB애 저장하는 서비스
    public MemoResponseDto write(MemoRequestDto memoRequestDto){
        Memo memo = new Memo(memoRequestDto);
        memoRepository.save(memo);

        return new MemoResponseDto(memo);
    }

    //글을 DB에서 가져온다
    public MemoResponseDto read(Long id){
        Memo memo = findId(id);

        return new MemoResponseDto(memo);
    }

    //글을 수정한다.
    @Transactional
    public MemoResponseDto edit(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = findId(id);
        memo.update(memoRequestDto);

        return new MemoResponseDto(memo);
    }

    //글을 삭제한다.
    @Transactional
    public Boolean delete(Long id){
        memoRepository.deleteById(id);
        return true;
    }

    @Transactional
    public Memo findId(Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return memo;
    }
}
