package com.povo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * @className: WorkerEntity
 * @description: TODO 类描述
 * @author: LiXiangyu
 * @date: 2021/8/5 16:17
 **/
@Entity
@Table(name = "worker", schema = "dormitory", catalog = "")
public class WorkerEntity {
    private String workerid;
    private String password;
    private String realname;
    private String phone;
    private String scope;
    private Collection<RepairEntity> repairsByWorkerid;

    @Id
    @Column(name = "workerid")
    public String getWorkerid() {
        return workerid;
    }

    public void setWorkerid(String workerid) {
        this.workerid = workerid;
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

    @Basic
    @Column(name = "scope")
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerEntity that = (WorkerEntity) o;
        return Objects.equals(workerid, that.workerid) && Objects.equals(password, that.password) && Objects.equals(realname, that.realname) && Objects.equals(phone, that.phone) && Objects.equals(scope, that.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerid, password, realname, phone, scope);
    }

    @OneToMany(mappedBy = "workerByWid")
    public Collection<RepairEntity> getRepairsByWorkerid() {
        return repairsByWorkerid;
    }

    public void setRepairsByWorkerid(Collection<RepairEntity> repairsByWorkerid) {
        this.repairsByWorkerid = repairsByWorkerid;
    }
}
