package com.xiaoyi.personalweb.mapper;

import com.xiaoyi.personalweb.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void userTest(){

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

        User user = new User();
        user.setUsername("test3");
        user.setPassword("aasasf");
        userMapper.insert(user);

    }

}
