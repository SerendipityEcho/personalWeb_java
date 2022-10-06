package com.xiaoyi.personalweb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("price")
public class Price extends BaseEntity{
    @TableId("price_id")
    private Integer id;
    @TableField("product_id")
    private Integer productId;
    private BigDecimal price;
}
