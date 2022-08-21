package com.xiaoyi.personalweb;

import com.xiaoyi.personalweb.entity.UserInfo;
import com.xiaoyi.personalweb.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonalwebApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void contextLoads() {
        UserInfo userInfo = userInfoService.queryById("1");
        System.out.println(userInfo);
    }

}
