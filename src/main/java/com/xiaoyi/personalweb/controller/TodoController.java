package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.Todo;
import com.xiaoyi.personalweb.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // 增
    @PostMapping
    public Result addTodo(Todo todo){
        return todoService.add(todo);
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
    public Result queryByPage(Todo todo){
        return todoService.queryByPage(todo);
    }

}
