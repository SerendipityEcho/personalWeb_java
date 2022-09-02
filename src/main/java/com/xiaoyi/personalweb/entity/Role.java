package com.xiaoyi.personalweb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@TableName("role")
public class Role extends BaseEntity {

    @TableId("role_id")
    private Integer id;
    @TableField("role_name")
    private String roleName;
    @TableField("role_intro")
    private String roleIntro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(roleIntro, role.roleIntro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, roleName, roleIntro);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleIntro='" + roleIntro + '\'' +
                '}' + super.toString();
    }
}
