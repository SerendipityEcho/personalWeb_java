package com.xiaoyi.personalweb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@TableName("access")
public class Access extends BaseEntity{
    @TableField("access_id")
    private Integer id;
    private String permission; // 权限
    private String description; // 权限描述信息

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Access access = (Access) o;
        return Objects.equals(id, access.id) &&
                Objects.equals(permission, access.permission) &&
                Objects.equals(description, access.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, permission, description);
    }

    @Override
    public String toString() {
        return "Access{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", description='" + description + '\'' +
                '}' + super.toString();
    }
}
