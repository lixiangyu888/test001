package com.povo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @className: RepairEntity
 * @description: TODO 类描述
 * @author: LiXiangyu
 * @date: 2021/8/5 16:17
 **/
@Entity
@Table(name = "repair", schema = "dormitory", catalog = "")
public class RepairEntity {
    private int repairid;
    private int eid;
    private String scope;
    private String uid;
    private Timestamp userDate;
    private String state;
    private String wid;
    private Timestamp workeDate;
    private String score;
    private EquipmentEntity equipmentByEid;
    private UserEntity userByUid;
    private WorkerEntity workerByWid;

    @Id
    @Column(name = "repairid")
    public int getRepairid() {
        return repairid;
    }

    public void setRepairid(int repairid) {
        this.repairid = repairid;
    }

    @Basic
    @Column(name = "eid")
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "scope")
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Basic
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "userDate")
    public Timestamp getUserDate() {
        return userDate;
    }

    public void setUserDate(Timestamp userDate) {
        this.userDate = userDate;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "wid")
    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    @Basic
    @Column(name = "workeDate")
    public Timestamp getWorkeDate() {
        return workeDate;
    }

    public void setWorkeDate(Timestamp workeDate) {
        this.workeDate = workeDate;
    }

    @Basic
    @Column(name = "score")
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepairEntity that = (RepairEntity) o;
        return repairid == that.repairid && eid == that.eid && Objects.equals(scope, that.scope) && Objects.equals(uid, that.uid) && Objects.equals(userDate, that.userDate) && Objects.equals(state, that.state) && Objects.equals(wid, that.wid) && Objects.equals(workeDate, that.workeDate) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repairid, eid, scope, uid, userDate, state, wid, workeDate, score);
    }

    @ManyToOne
    @JoinColumn(name = "eid", referencedColumnName = "equipmentid", nullable = false)
    public EquipmentEntity getEquipmentByEid() {
        return equipmentByEid;
    }

    public void setEquipmentByEid(EquipmentEntity equipmentByEid) {
        this.equipmentByEid = equipmentByEid;
    }

    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName = "userid", nullable = false)
    public UserEntity getUserByUid() {
        return userByUid;
    }

    public void setUserByUid(UserEntity userByUid) {
        this.userByUid = userByUid;
    }

    @ManyToOne
    @JoinColumn(name = "wid", referencedColumnName = "workerid")
    public WorkerEntity getWorkerByWid() {
        return workerByWid;
    }

    public void setWorkerByWid(WorkerEntity workerByWid) {
        this.workerByWid = workerByWid;
    }
}
