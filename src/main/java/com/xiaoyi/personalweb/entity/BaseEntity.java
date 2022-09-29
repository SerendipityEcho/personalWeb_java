package com.xiaoyi.personalweb.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
class BaseEntity implements Serializable {

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createUserId; //日志-创建人

    @TableField("create_time")
    private Date createTime ;    //日志-创建时间

    @TableField(value = "update_by",fill = FieldFill.INSERT_UPDATE)
    private String updateUserId; //日志-最后修改执行人

    @TableField("update_time")
    private Date updateTime;     //日志-最后修改时间

    @TableLogic
    @TableField("delete_status")
    private Integer deleteStatus; // 删除状态，实现逻辑删除

}
