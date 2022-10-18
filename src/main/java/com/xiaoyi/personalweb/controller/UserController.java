package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.annotation.CurrentUser;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.User;
import com.xiaoyi.personalweb.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public Result getUserInfo(@CurrentUser User user){
//        List list = userService.queryByList(user);
        return Result.getSuccessResult(user);
    }

    @GetMapping("/list")
    public Result getUserList(User user){
        List userList = userService.queryByList(user);
        return Result.getSuccessResult(userList);
    }
}
