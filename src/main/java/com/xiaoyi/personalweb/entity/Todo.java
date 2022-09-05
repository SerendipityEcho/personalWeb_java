package com.xiaoyi.personalweb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@TableName("todo")
public class Todo extends BaseEntity{
    @TableId("todo_id")
    private Integer id;
    @TableField("user_id")
    private Integer userId; // 当事人
    @TableField("start_time")
    private Date startTime; // 开始时间
    @TableField("end_time")
    private Date endTime; // 结束时间
    private String content; // 内容
    private String level; // 重要级别
    private String finished; // 是否完成
}
