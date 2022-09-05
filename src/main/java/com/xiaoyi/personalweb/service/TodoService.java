package com.xiaoyi.personalweb.service;

import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.Todo;

public interface TodoService {

    Result add(Todo todo);

    Result deleteById(int id);

    Result updateById(Todo todo);

    Result queryByPage(Todo todo);

}
