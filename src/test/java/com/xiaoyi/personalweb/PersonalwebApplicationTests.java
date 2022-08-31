package com.xiaoyi.personalweb;

import com.xiaoyi.personalweb.entity.User;
import com.xiaoyi.personalweb.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonalwebApplicationTests {

    @Autowired
    private UserMapper userInfoService;

    @Test
    void contextLoads() {
        User userInfo = userInfoService.selectById("1");
        System.out.println(userInfo);
    }

}
