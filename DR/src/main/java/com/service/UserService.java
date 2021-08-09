package com.service;

import com.povo.EquipmentEntity;
import com.povo.RepairEntity;
import com.povo.UserEntity;
import java.util.List;

public interface UserService {
    public UserEntity findUserById(String userid);
    public boolean regist(UserEntity userEntity);
    public boolean login(String userid,String password);
    public void update(UserEntity userEntity);
    public List<RepairEntity> findRepairByUid(String userid);
    public RepairEntity findRepairById(Integer repairid);
    public EquipmentEntity findEquipmentByRepair(Integer repairid);
    public void addRepair(RepairEntity repairEntity,EquipmentEntity equipmentEntity);
    public void scoreRepair(Integer repairid,String score);
}
