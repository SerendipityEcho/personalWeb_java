package com.xiaoyi.personalweb.service.impl;

import com.xiaoyi.personalweb.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    /**
     * 通过用户名密码验证用户登录
     * @param username 用户名
     * @param password 密码
     * @return 验证通过返回true
     */
    public boolean login(String username, String password){
        return "admin".equals(username) && "111111".equals(password);
    }

}
