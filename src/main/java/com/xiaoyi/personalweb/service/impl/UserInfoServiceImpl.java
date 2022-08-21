package com.xiaoyi.personalweb.service.impl;

import com.xiaoyi.personalweb.entity.Page;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.UserInfo;
import com.xiaoyi.personalweb.mapper.UserInfoMapper;
import com.xiaoyi.personalweb.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean deleteUserById(int id) {
        int row = userInfoMapper.deleteUserById(id);
        return row > 0;
    }

    @Override
    public Result saveUser(UserInfo userInfo) {
        if (userInfoMapper.existsUserName(userInfo.getUserName()) > 0){
            return new Result("","用户名重复",false);
        }
        int row = userInfoMapper.saveUser(userInfo);
        return new Result(row > 0);
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        int row = userInfoMapper.updateUserInfo(userInfo);
        return row > 0;
    }

    @Override
    public Page<UserInfo> queryByList(UserInfo userInfo, Page<UserInfo> page) {
//      查询到用户列表数据后放入page对象
        List<UserInfo> userInfoList = userInfoMapper.queryByList(userInfo,page.getStart(),page.getLimit());
        page.setList(userInfoList);
//      查询总用户数
        page.setTotal(userInfoMapper.userCount(userInfo));
        return page;
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        UserInfo user = userInfoMapper.selectByUserName(userInfo.getUserName());
        if (user == null || !(user.getPassword().equals(userInfo.getPassword()))){
            return new UserInfo();
        }
        user.setPassword("");
        return user;
    }

    @Override
    public UserInfo queryById(String id) {
        return userInfoMapper.queryById(id);
    }

}
