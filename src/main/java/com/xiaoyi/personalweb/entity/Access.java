package com.xiaoyi.personalweb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("access")
public class Access extends BaseEntity{
    @TableField("access_id")
    private Integer id;
    private String permission; // 权限
    private String description; // 权限描述信息

}
