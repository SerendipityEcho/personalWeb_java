package com.xiaoyi.personalweb.service;

import com.xiaoyi.personalweb.entity.Page;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.UserInfo;

public interface UserInfoService {

    //  删除一个用户
    boolean deleteUserById(int id);

    //  添加用户
    Result saveUser(UserInfo userInfo);

    //  修改用户信息
    boolean updateUserInfo(UserInfo userInfo);

    //  通过条件模糊查询用户信息列表
    Page<UserInfo> queryByList(UserInfo userInfo, Page<UserInfo> page);

    //  验证用户名密码
    UserInfo login(UserInfo userInfo);

    // 通过id查询用户信息
    UserInfo queryById(String id);

}
