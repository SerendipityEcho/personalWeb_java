package com.xiaoyi.personalweb.service.impl;

import com.xiaoyi.personalweb.entity.Access;
import com.xiaoyi.personalweb.entity.Result;
import com.xiaoyi.personalweb.service.AccessService;
import org.springframework.stereotype.Service;

@Service
public class AccessServiceImpl implements AccessService {

    @Override
    public Result getList(Access access) {
        return Result.getSuccessResult("cg");
    }
}
