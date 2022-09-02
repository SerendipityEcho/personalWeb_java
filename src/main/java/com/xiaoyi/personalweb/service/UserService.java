package com.xiaoyi.personalweb.service;

import com.xiaoyi.personalweb.entity.User;

import java.util.List;

public interface UserService {

    User queryById(String userId);
    //  删除一个用户
    boolean deleteUserById(int id);

    //  添加用户
    boolean saveUser(User userInfo);

    //  修改用户信息
    boolean updateUserInfo(User userInfo);

    //  通过条件模糊查询用户信息列表
    List queryByList(User userInfo);
}
