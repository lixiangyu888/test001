package com.povo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * @className: EquipmentEntity
 * @description: TODO 类描述
 * @author: LiXiangyu
 * @date: 2021/8/5 16:17
 **/
@Entity
@Table(name = "equipment", schema = "dormitory", catalog = "")
public class EquipmentEntity {
    private int equipmentid;
    private String building;
    private String floor;
    private String room;
    private String scope;
    private Collection<RepairEntity> repairsByEquipmentid;

    @Id
    @Column(name = "equipmentid")
    public int getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(int equipmentid) {
        this.equipmentid = equipmentid;
    }

    @Basic
    @Column(name = "building")
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Basic
    @Column(name = "floor")
    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Basic
    @Column(name = "room")
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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
        EquipmentEntity that = (EquipmentEntity) o;
        return equipmentid == that.equipmentid && Objects.equals(building, that.building) && Objects.equals(floor, that.floor) && Objects.equals(room, that.room) && Objects.equals(scope, that.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentid, building, floor, room, scope);
    }

    @OneToMany(mappedBy = "equipmentByEid")
    public Collection<RepairEntity> getRepairsByEquipmentid() {
        return repairsByEquipmentid;
    }

    public void setRepairsByEquipmentid(Collection<RepairEntity> repairsByEquipmentid) {
        this.repairsByEquipmentid = repairsByEquipmentid;
    }
}
