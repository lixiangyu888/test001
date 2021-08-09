package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.povo.WorkerEntity;
import com.service.AdminService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@Scope("prototype")
public class adminWorker extends ActionSupport implements ModelDriven<WorkerEntity>{
	private WorkerEntity worker = new WorkerEntity();
	@Resource(name="adminService")
	private AdminService as;
	private String msg_w = "";
	private String workerid;
	private List<WorkerEntity> workers;
	//管理员修改维修工信息
	public String adminUpdateWorker() {
		if(worker!=null){
			if(worker.getScope().equals("0"))
				worker.setScope("网络");
			else if(worker.getScope().equals("1"))
				worker.setScope("水电");
			else
				worker.setScope("门窗");
			as.updateWorker(worker);
			msg_w = "维修工"+worker.getWorkerid()+"的信息已修改！";
			setWorkers(as.findAllWorker());
			return SUCCESS;
		}
		else{
			msg_w = "error";
			return "fail";
		}
	}
	//管理员增加维修工
	public String adminAddWorker() {
		if(worker.getScope().equals("0"))
			worker.setScope("网络");
		else if(worker.getScope().equals("1"))
			worker.setScope("水电");
		else
			worker.setScope("门窗");
		as.save(worker);
		setWorkers(as.findAllWorker());
		msg_w = "已添加维修工："+worker.getWorkerid()+"!";
		return SUCCESS;
	}
	public void validateUpdate() {
		Pattern p = Pattern.compile("^1\\d{10}$");  //正则匹配，以1开头的11位数字
		Matcher m = p.matcher(worker.getPhone().trim());
        if(worker.getPassword() == null||worker.getPassword().equals("")){
            this.addFieldError("password", "密码不能为空");
        }else if(worker.getPhone() == null||worker.getPhone().equals("")){
            this.addFieldError("phone", "手机号不能为空");
        }else if(m.find()!=true ){
            this.addFieldError("phone", "手机号为1开头的11位数字");
        }
	}
	public WorkerEntity getWorker() {
		return worker;
	}
	public void setWorker(WorkerEntity worker) {
		this.worker = worker;
	}
	public String getMsg_w() {
		return msg_w;
	}
	public void setMsg_w(String msg_w) {
		this.msg_w = msg_w;
	}
	public List<WorkerEntity> getWorkers() {
		return workers;
	}
	public void setWorkers(List<WorkerEntity> workers) {
		this.workers = workers;
	}
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	@Override
	public WorkerEntity getModel() {
		// TODO Auto-generated method stub
		return worker;
	}

}
