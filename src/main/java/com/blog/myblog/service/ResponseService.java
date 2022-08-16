package com.blog.myblog.service;

import com.blog.myblog.domain.CommonResponse;
import com.blog.myblog.domain.ListResponse;
import com.blog.myblog.domain.Memo;
import com.blog.myblog.domain.SingleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {
    public<T> SingleResponse<T> getSingleResponse(T data){
        SingleResponse singleResponse = new SingleResponse();
        singleResponse.setData(data);
        setSuccessResponse(singleResponse);

        return singleResponse;
    }

    public ListResponse getListResponse(List<Memo> data){
        ListResponse listResponse = new ListResponse();
        listResponse.setMemoDtoList(data);
        setSuccessResponse(listResponse);

        return listResponse;
    }

    void setSuccessResponse(CommonResponse commonResponse){
        commonResponse.setSuccess(true);
        commonResponse.setError(null);
    }
}
