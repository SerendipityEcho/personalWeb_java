package com.xiaoyi.personalweb.service;

import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.entity.Role;

public interface RoleService {

    // 添加角色
    Result addRole(Role role);
    // 删除角色
    // 修改角色
    // 查询角色列表
    Result queryList(Role role);
}
