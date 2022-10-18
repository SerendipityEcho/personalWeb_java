package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.annotation.CurrentUserId;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.Todo;
import com.xiaoyi.personalweb.service.TodoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Resource
    private TodoService todoService;

    // 增
    @PostMapping
    public Result addTodo(Todo todo, @CurrentUserId Integer userId){
        return todoService.add(todo, userId);
    }
    // 删
    @DeleteMapping
    public Result deleteById(int id){
        return todoService.deleteById(id);
    }
    // 改
    @PutMapping
    public Result updateById(Todo todo){
        return todoService.updateById(todo);
    }
    // 查
    @GetMapping
    public Result queryByPage(Todo todo, @CurrentUserId Integer userId){
        return todoService.queryByPage(todo, userId);
    }

}
