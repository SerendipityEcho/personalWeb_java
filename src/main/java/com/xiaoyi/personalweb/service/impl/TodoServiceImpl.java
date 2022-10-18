package com.xiaoyi.personalweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.Todo;
import com.xiaoyi.personalweb.mapper.TodoMapper;
import com.xiaoyi.personalweb.service.TodoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    @Resource
    private TodoMapper todoMapper;

    @Override
    public Result add(Todo todo, Integer userId) {
        todo.setUserId(userId);
        Date date = new Date();
        todo.setStartTime(date);
        todo.setEndTime(date);
        todo.setLevel("3");
        System.out.println(todo);
        todoMapper.insert(todo);
        return Result.getSuccessResult("添加成功");
    }

    @Override
    public Result deleteById(Integer id) {
        int row = todoMapper.deleteById(id);
        if (row > 0){
            return Result.getSuccessResult(row, "删除成功");
        }
        return Result.getFailedResult(row,"删除失败，发生未知错误");
    }

    @Override
    public Result updateById(Todo todo) {
        int row = todoMapper.updateById(todo);
        if (row >= 1) return Result.getSuccessResult("修改成功！");
        return Result.getFailedResult("修改失败！");
    }

    @Override
    public Result queryByPage(Todo todo, Integer userId) {
        QueryWrapper<Todo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId.toString());
        List<Todo> todos = todoMapper.selectList(queryWrapper);
        return Result.getSuccessResult(todos);
    }
}
