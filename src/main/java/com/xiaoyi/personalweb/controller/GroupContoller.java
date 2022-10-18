package com.xiaoyi.personalweb.controller;

import com.xiaoyi.personalweb.entity.Group;
import com.xiaoyi.personalweb.service.GroupService;
import com.xiaoyi.personalweb.util.ResultBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/group")
public class GroupContoller {

    @Resource
    private GroupService groupService;

    public ResultBody addGroup(Group group){
        return ResultBody.success();
    }

}
