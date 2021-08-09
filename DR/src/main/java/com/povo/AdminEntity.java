package com.povo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @className: AdminEntity
 * @description: TODO 类描述
 * @author: LiXiangyu
 * @date: 2021/8/5 16:17
 **/
@Entity
@Table(name = "admin", schema = "dormitory", catalog = "")
public class AdminEntity {
    private String adminid;
    private String password;
    private String realname;
    private String phone;

    @Id
    @Column(name = "adminid")
    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "realname")
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminEntity that = (AdminEntity) o;
        return Objects.equals(adminid, that.adminid) && Objects.equals(password, that.password) && Objects.equals(realname, that.realname) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminid, password, realname, phone);
    }
}
