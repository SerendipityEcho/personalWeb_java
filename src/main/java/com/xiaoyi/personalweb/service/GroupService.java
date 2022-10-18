package com.xiaoyi.personalweb.service;

import com.xiaoyi.personalweb.entity.Group;
import com.xiaoyi.personalweb.util.ResultBody;

public interface GroupService {

    ResultBody addGroup(Group group);
    ResultBody delById(Integer id);
    ResultBody updateGroup(Group group);
    ResultBody queryByPage(Group group);

}
