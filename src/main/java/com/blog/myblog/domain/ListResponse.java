package com.blog.myblog.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResponse<T> extends CommonResponse {
    List<T> dataList;
}
