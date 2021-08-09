package com.service.impl;

import com.dao.EquipmentDAO;
import com.dao.RepairDAO;
import com.dao.UserDAO;
import com.povo.EquipmentEntity;
import com.povo.RepairEntity;
import com.povo.UserEntity;
import com.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name = "userDAO")
	private UserDAO ud;
	@Resource(name = "repairDAO")
	private RepairDAO rd;
	@Resource(name = "equipmentDAO")
	private EquipmentDAO ed;
	private RepairEntity repairEntity= new RepairEntity();
	//根据id查找学生
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public UserEntity findUserById(String userid)
	{
		return ud.findById(userid);	
	}
	//注册
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public boolean regist(UserEntity user)
	{
		ud.save(user);
		return true;
	}
	//登录
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public boolean login(String userid,String password)
	{
		if(ud.findById(userid)!=null&&ud.findById(userid).getPassword().equals(password))
			return true;
		else
			return false;
	}
	//学生更新自身信息
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public void update(UserEntity user)
	{
		ud.update(user);
	}
	//根据学生id查找学生报修记录
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public List<RepairEntity> findRepairByUid(String userid)
	{
		return rd.findByUid(userid);
	}
	//根据报修id查找报修记录
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public RepairEntity findRepairById(Integer repairid)
	{
		return rd.findById(repairid);
	}
	//学生对报修确认并对结果评分
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public void scoreRepair(Integer repairid,String score) {
		repairEntity=rd.findById(repairid);
		repairEntity.setState("已结束");
		repairEntity.setScore(score);
		rd.update(repairEntity);
	}
	//学生由报修记录确认报修设备
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public EquipmentEntity findEquipmentByRepair(Integer repairid) {
		return ed.findById(rd.findById(repairid).getEid());
	}
	//学生添加报修记录
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public void addRepair(RepairEntity repairEntity,EquipmentEntity equipmentEntity){
		if(ed.findByEquimpent(equipmentEntity)!=null){
			repairEntity.setEid(ed.findByEquimpent(equipmentEntity).getEquipmentid());
		}else{
			ed.save(equipmentEntity);
			repairEntity.setEid(ed.findByEquimpent(equipmentEntity).getEquipmentid());
		}
		repairEntity.setState("未开始");
		Timestamp date = new Timestamp(new Date().getTime());
		repairEntity.setUserDate(date);
		rd.save(repairEntity);
	}
}
