package com.blog.myblog.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ListResponse extends CommonResponse {
    List<MemoListResponseDto> memoListDta;
    public void setMemoDtoList(List<Memo> memoList){
        memoListDta = new ArrayList<MemoListResponseDto>();
        for(Memo memo:memoList){
            memoListDta.add(new MemoListResponseDto(memo));
        }

    }
}
