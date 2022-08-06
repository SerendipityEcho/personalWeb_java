package com.xiaoyi.personalweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaoyi.personalweb.mapper")
public class PersonalwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalwebApplication.class, args);
    }

}
