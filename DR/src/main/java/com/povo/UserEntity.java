package com.povo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * @className: UserEntity
 * @description: TODO 类描述
 * @author: LiXiangyu
 * @date: 2021/8/5 16:17
 **/
@Entity
@Table(name = "user", schema = "dormitory", catalog = "")
public class UserEntity {
    private String userid;
    private String password;
    private String realname;
    private String sex;
    private String phone;
    private Collection<RepairEntity> repairsByUserid;

    @Id
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
        UserEntity that = (UserEntity) o;
        return Objects.equals(userid, that.userid) && Objects.equals(password, that.password) && Objects.equals(realname, that.realname) && Objects.equals(sex, that.sex) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, password, realname, sex, phone);
    }

    @OneToMany(mappedBy = "userByUid")
    public Collection<RepairEntity> getRepairsByUserid() {
        return repairsByUserid;
    }

    public void setRepairsByUserid(Collection<RepairEntity> repairsByUserid) {
        this.repairsByUserid = repairsByUserid;
    }
}
