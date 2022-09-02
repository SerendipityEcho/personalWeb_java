package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.User;
import com.xiaoyi.personalweb.service.LoginService;
import com.xiaoyi.personalweb.service.UserService;
import com.xiaoyi.personalweb.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        boolean resultUserInfo = loginService.login(user.getUsername(),user.getPassword());
        if (resultUserInfo){
            user.setId(1);
            String sign = TokenUtil.sign(user);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("token",sign);
            resultMap.put("userInfo", user);
            return Result.getSuccessResult(resultMap);
        }else {
            return Result.getFailedResult(user, "用户名密码错误！");
        }
    }

    @PostMapping("/logout")
    public Result logout(){
        System.out.println("有人退出登录了");
        return Result.getSuccessResult("退出成功！");
    }

}
