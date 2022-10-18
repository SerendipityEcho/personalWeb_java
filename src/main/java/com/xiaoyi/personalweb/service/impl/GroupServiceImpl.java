package com.xiaoyi.personalweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoyi.personalweb.entity.Group;
import com.xiaoyi.personalweb.mapper.GroupMapper;
import com.xiaoyi.personalweb.service.GroupService;
import com.xiaoyi.personalweb.util.ResultBody;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Resource
    private GroupMapper groupMapper;

    @Override
    public ResultBody addGroup(Group group) {
        int row = groupMapper.insert(group);
        if (row > 0){
            return ResultBody.success(group.getId());
        }else {
            return ResultBody.error("添加分组失败！");
        }
    }

    @Override
    public ResultBody delById(Integer id) {
        if (id != null){
            int row = groupMapper.deleteById(id);
            if (row > 0){
                return ResultBody.success();
            }
        }
        return ResultBody.error("删除失败！");
    }

    @Override
    public ResultBody updateGroup(Group group) {
        if (group.getId() == null){
            return ResultBody.error("组id为空！");
        }
        int row = groupMapper.updateById(group);
        if (row > 0){
            return ResultBody.success();
        }
        return ResultBody.error("网络波动，修改失败！");
    }

    @Override
    public ResultBody queryByPage(Group group) {
        Page<Group> page = new Page<>();
        QueryWrapper<Group> wrapper = new QueryWrapper<>();
        wrapper.like(group.getName() != null,"name", group.getName());
        Page<Group> groupPage = groupMapper.selectPage(page, wrapper);
        return ResultBody.success(groupPage);
    }
}
