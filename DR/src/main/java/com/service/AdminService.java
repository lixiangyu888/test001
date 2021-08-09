package com.service;

import com.povo.EquipmentEntity;
import com.povo.RepairEntity;
import com.povo.UserEntity;
import com.povo.WorkerEntity;

import java.util.List;

public interface AdminService {
    //登录
    boolean login(String userid,String password);
    //用户管理
    //查找所有学生信息
    List<UserEntity> findAllUser();
    //根据id查找学生
    UserEntity findUserById(String userid);
    //增加学生信息
    void saveUser(UserEntity user);
    //删除学生信息
    void deleteUser(String userid);
    //更新学生信息
    void updateUser(UserEntity user);

    //维修人员管理
    //根据id查找维修工
    WorkerEntity findWorkerById(String workerid);
    //查找所有维修人员信息
    List<WorkerEntity> findAllWorker();
    //增加管理员信息
    void save(WorkerEntity worker);
    //删除维修工信息
    void deleteWorker(String workerid);
    //更新维修工信息
    void updateWorker(WorkerEntity worker);

    //维修记录管理
    //查看所有维修记录
    List<RepairEntity> findAllRepair();
    //根据维修工id查找维修记录
    List<RepairEntity> findRepairByWorkerid(String workerid) ;
    //根据设备id查找维修记录
    List<RepairEntity> findRepairByEquipmentid(Integer equipmentid);
    //根据设备id查找设备
    EquipmentEntity findEquipmentBy(Integer equipmentid);
}
