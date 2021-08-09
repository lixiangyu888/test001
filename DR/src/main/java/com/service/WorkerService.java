package com.service;

import com.povo.RepairEntity;
import com.povo.WorkerEntity;
import java.util.List;

public interface WorkerService {
    //登录
    public boolean login(String userid,String password);
    //根据id查找维修工
    public WorkerEntity findWorkerById(String workerid);
    //维修工更新自身信息
    public void update(WorkerEntity worker);
    //根据报修类型查找学生报修记录
    public List<RepairEntity> findRepairByScope(String workerid);
    //根据报修id查找学生报修记录
    public RepairEntity findRepairById(Integer repairid);
    //维修工修改报修记录状态
    public List<RepairEntity> updateRepair(RepairEntity repair);
}
