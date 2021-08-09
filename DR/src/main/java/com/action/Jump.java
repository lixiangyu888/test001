package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.povo.EquipmentEntity;
import com.povo.RepairEntity;
import com.povo.UserEntity;
import com.povo.WorkerEntity;
import com.service.AdminService;
import com.service.UserService;
import com.service.WorkerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.util.List;
@Controller
@Scope("prototype")

public class Jump extends ActionSupport {
	private String userid;
	private String workerid;
	private Integer repairid;
	private Integer score;
	private String msg_u="";
	private String msg_w="";
	private String msg = "";
	private UserEntity user = new UserEntity();
	private WorkerEntity worker = new WorkerEntity();
	private RepairEntity repair = new RepairEntity();
	private EquipmentEntity equipment = new EquipmentEntity();
	private List<UserEntity> users;
	private List<WorkerEntity> workers;
	private List<RepairEntity> repairs;
	@Resource(name="adminService")
	private AdminService as;
	@Resource(name="userService")
	private UserService us;
	@Resource(name="workerService")
	private WorkerService ws;
	//跳转到学生注册页面
	public String regJsp() {
		return SUCCESS;
	}
	//返回登录页面
	public String reLogin() {
		return SUCCESS;
	}
	//学生跳转到添加报修记录页面
	public String addRepairJsp() {
		setUserid(userid);
		return SUCCESS;
	}
	//学生跳转到修改信息界面
	public String userUpdateJsp() {
		setUser(us.findUserById(userid));
		return SUCCESS;
	}
	//学生跳转到查询报修记录页面
	public String searchUserRepairJsp() {
		setRepairs(us.findRepairByUid(userid));
		setUserid(userid);
		return SUCCESS;
	}
	//学生对报修记录评分页面
	public String scoreRepairJsp() {
		setRepair(us.findRepairById(repairid));
		setEquipment(us.findEquipmentByRepair(repairid));
		return SUCCESS;
	}
	
	//管理员跳转到查看全部学生信息页面
	public String userInformationJsp() {
		setUsers(as.findAllUser());
		return SUCCESS;
	}
	//管理员跳转到增加学生信息页面
	public String adminAddUserJsp() {
		return SUCCESS;
	}
	//管理员删除学生并返回全部学生信息页面
	public String adminDeleteUser() {
		if(as.findUserById(userid)!=null){
			msg_u= "已删除学生："+userid+"!";
			as.deleteUser(userid);
			setUsers(as.findAllUser());
			return SUCCESS;
		}
		else{
			setUsers(as.findAllUser());
			setUserid("");
			return "fail";
		}
	}
	//管理员跳转到修改学生信息页面
	public String adminUpdateUserJsp() {
		setUser(as.findUserById(userid));
		return SUCCESS;
	}
	//管理员跳转到查看全部维修工信息页面
	public String workerInformationJsp() {
		setWorkers(as.findAllWorker());
		return SUCCESS;
	}
	//管理员跳转到增加维修工信息页面
	public String adminAddWorkerJsp() {
		return SUCCESS;
	}
	//管理员删除维修工信息并返回全部维修工信息页面
	public String adminDeleteWorker() {
		if(as.findWorkerById(workerid)!=null){
			msg_w= "已删除维修工："+workerid+"!";
			as.deleteWorker(workerid);
			setWorkers(as.findAllWorker());
			return SUCCESS;
		}
		else{
			setWorkers(as.findAllWorker());
			setWorkerid("");
			return "fail";
		}
	}
	//管理员跳转到修改维修工信息页面
	public String adminUpdateWorkerJsp() {
		setWorker(as.findWorkerById(workerid));
		return SUCCESS;
	}
	//管理员跳转到查看维修记录页面
	public String repairMainJsp() {
		setRepairs(as.findAllRepair());
		return SUCCESS;
	}
	
	//维修人员跳转到修改信息页面
	public String workerUpdateJsp() {
		setWorker(ws.findWorkerById(workerid));
		return SUCCESS;
	}
	//维修人员跳转到查看维修记录页面
	public String workerScopeRepairJsp() {
		setRepairs(ws.findRepairByScope(workerid));
		return SUCCESS;
	}
	public String getUserid() {
		return userid;
	}
	public String getMsg_u() {
		return msg_u;
	}
	public void setMsg_u(String msg_u) {
		this.msg_u = msg_u;
	}
	public String getMsg_w() {
		return msg_w;
	}
	public void setMsg_w(String msg_w) {
		this.msg_w = msg_w;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	public List<WorkerEntity> getWorkers() {
		return workers;
	}
	public void setWorkers(List<WorkerEntity> workers) {
		this.workers = workers;
	}
	public List<RepairEntity> getRepairs() {
		return repairs;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public WorkerEntity getWorker() {
		return worker;
	}
	public void setWorker(WorkerEntity worker) {
		this.worker = worker;
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
	public Integer getRepairid() {
		return repairid;
	}
	public void setRepairid(Integer repairid) {
		this.repairid = repairid;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public EquipmentEntity getEquipment() {
		return equipment;
	}
	public void setEquipment(EquipmentEntity equipment) {
		this.equipment = equipment;
	}
}