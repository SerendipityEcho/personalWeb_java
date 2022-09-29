package com.xiaoyi.personalweb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("product")
public class product extends BaseEntity {

    @TableId("product_id")
    private Integer id;
    @TableField
    private String name;
    @TableField
    private BigDecimal price;

}
