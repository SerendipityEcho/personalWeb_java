package com.xiaoyi.personalweb.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BaseEntity implements Serializable {

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

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(createUserId, that.createUserId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateUserId, that.updateUserId) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createUserId, createTime, updateUserId, updateTime);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createUserId='" + createUserId + '\'' +
                ", createTime=" + createTime +
                ", updateUserId='" + updateUserId + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
