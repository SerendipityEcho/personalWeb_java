package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.UserInfo;
import com.xiaoyi.personalweb.service.UserInfoService;
import com.xiaoyi.personalweb.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping
    public Result login(@RequestBody UserInfo userInfo){
        UserInfo resultUserInfo = userInfoService.login(userInfo);
        if (resultUserInfo.getId() != null && !"".equals(resultUserInfo.getId())){
            String sign = TokenUtil.sign(resultUserInfo);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("token",sign);
            resultMap.put("userInfo", resultUserInfo);
            return Result.getSuccessResult(resultMap);
        }else {
            return Result.getFailedResult(userInfo, "用户名密码错误！");
        }
    }

}
