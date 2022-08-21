package com.xiaoyi.personalweb.mapper;

import com.xiaoyi.personalweb.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInfoMapper {

    //  添加一个新用户
    int saveUser(UserInfo userInfo);

    //  删除一个用户
    int deleteUserById(int id);

    //  更新用户信息
    int updateUserInfo(UserInfo userInfo);

    //  多条件分页查询
    List<UserInfo> queryByList(@Param("userInfo") UserInfo userInfo, @Param("start")int start, @Param("limit")int limit);

    //  获取数据表中总数据条数
    int userCount(UserInfo userInfo);

    //  根据用户名查询用户信息
    UserInfo selectByUserName(String userName);

    //  查询用户名是否重复
    int existsUserName(String userName);

    //  根据用户id查询用户信息
    UserInfo queryById(String userId);

}
