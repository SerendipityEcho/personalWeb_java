package com.xiaoyi.personalweb.service.impl;

import com.xiaoyi.personalweb.entity.User;
import com.xiaoyi.personalweb.mapper.UserMapper;
import com.xiaoyi.personalweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(String userId) {
        return new User();
    }
}
