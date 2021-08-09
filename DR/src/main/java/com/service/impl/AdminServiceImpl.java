package com.service.impl;

import com.dao.RepairDAO;
import com.dao.*;
import com.povo.EquipmentEntity;
import com.povo.RepairEntity;
import com.povo.UserEntity;
import com.povo.WorkerEntity;
import com.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Resource(name = "repairDAO")
	private RepairDAO rd;
	@Resource(name = "userDAO")
	private UserDAO ud;
	@Resource(name = "workerDAO")
	private WorkerDAO wd;
	@Resource(name = "adminDAO")
	private AdminDAO ad;
	@Resource(name = "equipmentDAO")
	private EquipmentDAO ed;
	private List<RepairEntity> repairs;
	//登录
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public boolean login(String userid,String password)
	{
		if(ad.findById(userid)!=null&&ad.findById(userid).getPassword().equals(password))
			return true;
		else
			return false;
	}
	//用户管理
	//查找所有学生信息
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public List<UserEntity> findAllUser()
	{
		return ud.findAll();
	}
	//根据id查找学生
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public UserEntity findUserById(String userid)
	{
		return ud.findById(userid);	
	}
	//增加学生信息
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public void saveUser(UserEntity user)
	{
		ud.save(user);	
	}
	//删除学生信息
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public void deleteUser(String userid)
	{
		ud.delete(ud.findById(userid));	
	}
	//更新学生信息
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public void updateUser(UserEntity user)
	{
		ud.update(user);
	}
	
	//维修人员管理
	//根据id查找维修工
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public WorkerEntity findWorkerById(String workerid)
	{
		return wd.findById(workerid);	
	}
	//查找所有维修人员信息
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public List<WorkerEntity> findAllWorker()
	{
		return wd.findAll();
	}
	//增加管理员信息
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public void save(WorkerEntity worker)
	{
		wd.save(worker);	
	}
	//删除维修工信息
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public void deleteWorker(String workerid)
	{
		wd.delete(wd.findById(workerid));	
	}
	//更新维修工信息
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public void updateWorker(WorkerEntity worker)
	{
		wd.update(worker);
	}
	
	//维修记录管理
	//查看所有维修记录
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public List<RepairEntity> findAllRepair() {
		return rd.findAll();
	}
	//根据维修工id查找维修记录
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public List<RepairEntity> findRepairByWorkerid(String workerid) {
		return rd.findByWid(workerid);
	}
	//根据设备id查找维修记录
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public List<RepairEntity> findRepairByEquipmentid(Integer equipmentid) {
		return rd.findByProperty("eid", equipmentid);
	}
	//根据设备id查找设备
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public EquipmentEntity findEquipmentBy(Integer equipmentid) {
		return ed.findById(equipmentid);
	}
}
