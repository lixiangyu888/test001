package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.povo.EquipmentEntity;
import com.povo.RepairEntity;
import com.service.AdminService;
import com.service.UserService;
import com.service.WorkerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.util.List;
@Controller
@Scope("prototype")

public class repairAction extends ActionSupport implements ModelDriven<RepairEntity>{
	private String userid;
	private String workerid;
	private Integer repairid;
	private Integer equipmentid;
	private String score;
	private RepairEntity repair = new RepairEntity();
	private String building;
	private String floor;
	private String room;
	private String scope;
	private EquipmentEntity equipment = new EquipmentEntity();
	@Resource(name="userService")
	private UserService us;
	@Resource(name="workerService")
	private WorkerService ws;
	@Resource(name="adminService")
	private AdminService as;
	private String msg = "";
	private String msgg ="";
	private List<RepairEntity> repairs;
	//学生增加报修记录
	public String addRepair() {
		if(repair.getScope().equals("0"))
			repair.setScope("网络");
		else if(repair.getScope().equals("1"))
			repair.setScope("水电");
		else
			repair.setScope("门窗");
		repair.setUid(userid);
		equipment.setBuilding(building);
		equipment.setFloor(floor);
		equipment.setRoom(room);
		equipment.setScope(repair.getScope());
		us.addRepair(repair,equipment);
		msg = "维修记录已上报！";
		setUserid(userid);
		setRepairs(us.findRepairByUid(userid));
		return SUCCESS;
	}
	//学生维修确认并进行评分
	public String repairScore() {
		us.scoreRepair(repair.getRepairid(), repair.getScore());
		setRepairs(us.findRepairByUid(us.findRepairById(repair.getRepairid()).getUserByUid().getUserid()));
		setUserid(us.findRepairById(repair.getRepairid()).getUserByUid().getUserid());
		msg = "感谢您的评分！";
		return SUCCESS;
	}
	//维修工修改报修记录
	public String repairStart() {
		setRepair(ws.findRepairById(repair.getRepairid()));
		repair.setState("进行中");
		repair.setWorkerByWid(ws.findWorkerById(workerid));
		setRepairs(ws.updateRepair(repair));
		msg="";
		return SUCCESS;
	}
	public String repairWait() {
		repair=ws.findRepairById(repair.getRepairid());
		repair.setState("待完成");
		setRepairs(ws.updateRepair(repair));
		msg="";
		return SUCCESS;
	}
	public String repairEnd() {
		repair=ws.findRepairById(repair.getRepairid());
		repair.setState("已维修");
		setRepairs(ws.updateRepair(repair));
		msg="";
		return SUCCESS;
	}
	
	//管理员根据维修工id查询报修记录
	public String searchWorkerRepairJsp() {
		setRepairs(as.findRepairByWorkerid(workerid));
		return SUCCESS;
	}
	//对维修工id校验
	public void validateSearchWorkerRepairJsp() {
		// TODO Auto-generated method stub
		if(workerid==null || workerid.equals(""))
	        this.addFieldError("workerid", "用户名不能为空！");
		else if(ws.findWorkerById(workerid)==null)
			this.addFieldError("workerid", "该维修工不存在！");
	    else if(as.findRepairByWorkerid(workerid)==null)
	        this.addFieldError("workerid", "该维修工无维修记录！");
	}
	//管理员根据设备id查询报修记录
	public String searchEquipmentRepairJsp() {
		setRepairs(as.findRepairByEquipmentid(equipmentid));
		return SUCCESS;
	}
	//对设备id校验
	public void validateSearchEquipmentRepairJsp() {
		// TODO Auto-generated method stub
		if(equipmentid==null || equipmentid.equals(""))
		    this.addFieldError("equipmentid", "设备号不能为空！");
		else if(as.findRepairByEquipmentid(equipmentid)==null)
			this.addFieldError("equipmentid", "该设备不存在！");
		else if(as.findRepairByEquipmentid(equipmentid)==null)
		    this.addFieldError("equipmentid", "该设备无维修记录！");
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Integer getEquipmentid() {
		return equipmentid;
	}
	public void setEquipmentid(Integer equipmentid) {
		this.equipmentid = equipmentid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsgg() {
		return msgg;
	}
	public void setMsgg(String msgg) {
		this.msgg = msgg;
	}
	public List<RepairEntity> getRepairs() {
		return repairs;
	}
	public void setRepairs(List<RepairEntity> repairs) {
		this.repairs = repairs;
	}
	public RepairEntity getRepair() {
		return repair;
	}
	public void setRepair(RepairEntity repair) {
		this.repair = repair;
	}
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	public Integer getRepairid() {
		return repairid;
	}
	public void setRepairid(Integer repairid) {
		this.repairid = repairid;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public EquipmentEntity getEquipment() {
		return equipment;
	}
	public void setEquipment(EquipmentEntity equipment) {
		this.equipment = equipment;
	}
	@Override
	public RepairEntity getModel() {
		// TODO Auto-generated method stub
		return repair;
	}
}
