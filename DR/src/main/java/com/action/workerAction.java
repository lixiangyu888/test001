package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.povo.WorkerEntity;
import com.service.WorkerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Controller
@Scope("prototype")

public class workerAction extends ActionSupport implements ModelDriven<WorkerEntity>{
	@Resource(name="workerService")
	private WorkerService ws;
	private String msg = "";
	private String workerid;
	private WorkerEntity worker = new WorkerEntity();
	//维修工修改个人信息
	public String workerUpdate() {
		if(worker!=null){
			if(worker.getScope().equals("0"))
				worker.setScope("网络");
			else if(worker.getScope().equals("1"))
				worker.setScope("水电");
			else
				worker.setScope("门窗");
			ws.update(worker);
			msg = "您的信息已修改！";
			setWorkerid(worker.getWorkerid());
			return SUCCESS;
		}
		else{
			msg = "error";
			return "fail";
		}
	}
	//管理员修改信息校验
	public void validateUserUpdate(){
		Pattern p = Pattern.compile("^1\\d{10}$");  //正则表达匹配手机号
		Matcher m = p.matcher(worker.getPhone().trim());
	    if(worker.getPassword() == null||worker.getPassword().equals("")){
	        this.addFieldError("password", "密码不能为空");
	    }else if(worker.getPhone() == null||worker.getPhone().equals("")){
	        this.addFieldError("phone", "手机号不能为空");
	    }else if(m.find()!=true ){
	        this.addFieldError("phone", "手机号为1开头的11位数字");
	    }
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public WorkerEntity getWorker() {
		return worker;
	}
	public void setWorker(WorkerEntity worker) {
		this.worker = worker;
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
