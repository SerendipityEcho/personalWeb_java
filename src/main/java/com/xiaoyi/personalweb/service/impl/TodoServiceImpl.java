package com.xiaoyi.personalweb.service.impl;

import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.Todo;
import com.xiaoyi.personalweb.mapper.TodoMapper;
import com.xiaoyi.personalweb.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoMapper todoMapper;

    @Override
    public Result add(Todo todo) {
        return null;
    }

    @Override
    public Result deleteById(int id) {
        return null;
    }

    @Override
    public Result updateById(Todo todo) {
        return null;
    }

    @Override
    public Result queryByPage(Todo todo) {
        List<Todo> todos = todoMapper.selectList(null);
        return Result.getSuccessResult(todos);
    }
}
