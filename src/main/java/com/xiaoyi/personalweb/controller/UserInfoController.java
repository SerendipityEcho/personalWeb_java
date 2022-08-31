package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.annotation.CurrentUser;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.User;
import com.xiaoyi.personalweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Result add(@RequestBody User userInfo) {
        return new Result(true);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id")int id) {
        return new Result(true);
    }

    @PutMapping
    public Result update(@RequestBody User userInfo) {
        return new Result(true);
    }

    @GetMapping
    public Result getList(User userInfoPage, @CurrentUser User userInfo) {
        return Result.getFailedResult("");
    }

}
