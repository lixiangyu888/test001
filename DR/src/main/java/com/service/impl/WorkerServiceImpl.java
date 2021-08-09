package com.service.impl;

import com.dao.EquipmentDAO;
import com.dao.RepairDAO;
import com.dao.WorkerDAO;
import com.povo.RepairEntity;
import com.povo.WorkerEntity;
import com.service.WorkerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Service("workerService")
public class WorkerServiceImpl implements WorkerService {
	@Resource(name = "workerDAO")
	private WorkerDAO wd;
	@Resource(name = "repairDAO")
	private RepairDAO rd;
	@Resource(name = "equipmentDAO")
	private EquipmentDAO ed;
	//登录
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public boolean login(String userid,String password)
	{
		if(wd.findById(userid)!=null&&wd.findById(userid).getPassword().equals(password))
			return true;
		else
			return false;
	}
	//根据id查找维修工
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public WorkerEntity findWorkerById(String workerid)
	{
		return wd.findById(workerid);	
	}
	//维修工更新自身信息
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public void update(WorkerEntity worker)
	{
		wd.update(worker);	
	}
	//根据报修类型查找学生报修记录
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public List<RepairEntity> findRepairByScope(String workerid)
	{
		return rd.findByScope(wd.findById(workerid).getScope());
	}
	//根据报修id查找学生报修记录
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public RepairEntity findRepairById(Integer repairid)
	{
		return rd.findById(repairid);
	}
	//维修工修改报修记录状态
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public List<RepairEntity> updateRepair(RepairEntity repair)
	{
		Timestamp date = new Timestamp(new Date().getTime());
		repair.setWorkeDate(date);
		rd.update(repair);
		return findRepairByScope(repair.getWorkerByWid().getWorkerid());
	}
}
