package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.entity.Access;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.service.AccessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/access")
public class AccessController {

    @Resource
    private AccessService accessService;

    @GetMapping
    public Result getAccessList(Access access){
        return accessService.getList(access);
    }

}
