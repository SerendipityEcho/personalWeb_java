package com.xiaoyi.personalweb.service.impl;

import com.xiaoyi.personalweb.entity.User;
import com.xiaoyi.personalweb.mapper.UserMapper;
import com.xiaoyi.personalweb.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryById(String userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public boolean deleteUserById(int id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public boolean saveUser(User userInfo) {
        int insert = userMapper.insert(userInfo);
        return insert > 0;
    }

    @Override
    public boolean updateUserInfo(User userInfo) {
        int i = userMapper.updateById(userInfo);
        return i > 0;
    }

    @Override
    public List queryByList(User userInfo) {
        List<User> users = userMapper.selectList(null);
        return users;
    }

}
