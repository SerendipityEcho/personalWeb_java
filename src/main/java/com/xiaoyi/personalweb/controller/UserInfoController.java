package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.annotation.CurrentUser;
import com.xiaoyi.personalweb.entity.Page;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.UserInfo;
import com.xiaoyi.personalweb.entity.vo.UserInfoPage;
import com.xiaoyi.personalweb.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping
    public Result add(@RequestBody UserInfo userInfo) {
        return userInfoService.saveUser(userInfo);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id")int id) {
        boolean isOk = userInfoService.deleteUserById(id);
        return new Result(isOk);
    }

    @PutMapping
    public Result update(@RequestBody UserInfo userInfo) {
        boolean isOk = userInfoService.updateUserInfo(userInfo);
        return new Result(isOk);
    }

    @GetMapping
    public Result getList(UserInfoPage userInfoPage, @CurrentUser UserInfo userInfo) {
        System.out.println("获取数据:"+userInfo);
        Page<UserInfo> page = new Page<>();
        page.setPageNow(userInfoPage.getPageNow());
        page = userInfoService.queryByList(userInfoPage, page);
        return Result.getSuccessResult(page);
    }

}
