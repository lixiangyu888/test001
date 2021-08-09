package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;

@Controller
@Scope("prototype")
public class login extends ActionSupport {
	private String userid;
	private String workerid;
	private String password;
	private String identity;
	private String msg = "";
	private String msgg = "";
	@Resource(name="userService")
	private UserService us;
	@Resource(name="workerService")
	private WorkerService ws;
	@Resource(name="adminService")
	private AdminService as;
	public String login() {
		//判断登录账号的身份
		if(identity.equals("0")){  //学生
			if(us.login(userid, password)){
				return "user";
			}
			else{
				this.addFieldError("userid", "学生账号或密码错误！");
				return "fail";
			}
		}else if(identity.equals("1")){  //维修工
			if(ws.login(userid, password)){
				setWorkerid(userid);
				msgg="欢迎您！"+ws.findWorkerById(userid).getScope()+"维修员 ^_^";
				return "worker";
			}else{    
				this.addFieldError("userid", "维修人员账号或密码错误！");
				return "fail";
			}
		}else if(identity.equals("2")){  //管理员
			if(as.login(userid, password)){
				msgg="管理员您好，欢迎登录！^_^";
				return "admin";
			}else{
				this.addFieldError("userid", "管理员账号或密码错误！");
				return "fail";
			}
		}else {
			return "fail";
		}
	}
	
	public void validateLogin() {
		if(userid==null || userid.equals(""))
            this.addFieldError("userid", "用户名不能为空");
        else if(password==null || password.equals(""))
            this.addFieldError("password", "密码不能为空");
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getWorkerid() {
		return workerid;
	}

	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}

	public String getMsgg() {
		return msgg;
	}

	public void setMsgg(String msgg) {
		this.msgg = msgg;
	}
	
}