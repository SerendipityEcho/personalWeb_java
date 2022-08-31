package com.xiaoyi.personalweb.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createUserId = getFieldValByName("createUserId", metaObject);
        if(createUserId == null) {
            setFieldValByName("createUserId", "0", metaObject);
        }
        Object updateUserId = getFieldValByName("updateUserId", metaObject);
        if(updateUserId == null) {
            setFieldValByName("updateUserId", "0", metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object fieldValue = getFieldValByName("updateUserId", metaObject);
        if(fieldValue == null) {
            setFieldValByName("updateUserId", "0", metaObject);
        }
    }
}
