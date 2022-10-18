package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.Role;
import com.xiaoyi.personalweb.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @PostMapping
    public Result addRole(Role role){
        return roleService.addRole(role);
    }

    @GetMapping
    public Result queryList(Role role){
        return roleService.queryList(role);
    }

}
