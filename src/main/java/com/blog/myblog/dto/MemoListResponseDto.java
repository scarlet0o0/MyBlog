package com.blog.myblog.dto;

import com.blog.myblog.domain.Memo;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MemoListResponseDto {
    private ArrayList<MemoResponseDto> memoListDta = new ArrayList<MemoResponseDto>();

    public MemoListResponseDto(List<Memo> memoList){
        for(Memo memo:memoList){
            memoListDta.add(new MemoResponseDto(memo));
        }
    }
}
