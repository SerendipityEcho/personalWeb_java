package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.entity.Group;
import com.xiaoyi.personalweb.service.GroupService;
import com.xiaoyi.personalweb.util.ResultBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Resource
    private GroupService groupService;

    @PostMapping
    public ResultBody addGroup(Group group){
        return groupService.addGroup(group);
    }

    @DeleteMapping
    public ResultBody delById(Integer id){
        return groupService.delById(id);
    }

    @PutMapping
    public ResultBody updateById(Group group){
        return groupService.updateGroup(group);
    }

    @GetMapping
    public ResultBody queryGroupByPage(Group group){
        return groupService.queryByPage(group);
    }

}
