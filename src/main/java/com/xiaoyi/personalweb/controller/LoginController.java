package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.User;
import com.xiaoyi.personalweb.service.LoginService;
import com.xiaoyi.personalweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody User userInfo){
        boolean resultUserInfo = loginService.login("","");
        if (resultUserInfo){
//            String sign = TokenUtil.sign(resultUserInfo);
//            Map<String, Object> resultMap = new HashMap<>();
//            resultMap.put("token",sign);
//            resultMap.put("userInfo", resultUserInfo);
            return Result.getSuccessResult("");
        }else {
            return Result.getFailedResult(userInfo, "用户名密码错误！");
        }
    }

}
