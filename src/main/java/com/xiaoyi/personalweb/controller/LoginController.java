package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.UserInfo;
import com.xiaoyi.personalweb.util.TokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @PostMapping
    public Result login(@RequestBody UserInfo userInfo){
        System.out.println("有人登录" + userInfo.toString());
        if (userInfo.getUserName() != null && !"".equals(userInfo.getUserName())){
            String sign = TokenUtil.sign(userInfo);
            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("token",sign);
            return Result.getSuccessResult(resultMap);
        }else {
            return Result.getFailedResult(userInfo);
        }
    }

}
