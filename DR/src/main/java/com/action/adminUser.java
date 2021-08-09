package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.povo.UserEntity;
import com.service.AdminService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Controller
@Scope("prototype")
public class adminUser extends ActionSupport implements ModelDriven<UserEntity>{
	private UserEntity user = new UserEntity();
	@Resource(name="adminService")
	private AdminService as;
	private List<UserEntity> users;
	private String msg_u = "";
	private String userid;
	//管理员修改学生信息
	public String adminUpdateUser() {
		// TODO Auto-generated method stub
		if(user!=null){
			if(user.getSex().equals("0"))
				user.setSex("男");
			else {
				user.setSex("女");
			}
			as.updateUser(user);
			msg_u = "学生"+user.getUserid()+"的信息已修改！";
			setUsers(as.findAllUser());
			return SUCCESS;
		}
		else{
			msg_u = "error";
			return "fail";
		}
	}
	//管理员增加学生信息
	public String adminAddUser() {
		as.saveUser(user);
		msg_u = "已添加学生："+user.getUserid()+"!";
		setUsers(as.findAllUser());
		return SUCCESS;
	}
	public void validateUpdate() {
		Pattern p = Pattern.compile("^1\\d{10}$"); //正则匹配，以1开头的11位数字
		Matcher m = p.matcher(user.getPhone().trim());
        if(user.getPassword() == null||user.getPassword().equals("")){
            this.addFieldError("password", "密码不能为空");
        }else if(user.getSex() == null||user.getSex().equals("")){
            this.addFieldError("sex", "性别不能为空");
        }else if(user.getPhone() == null||user.getPhone().equals("")){
            this.addFieldError("phone", "手机号不能为空");
        }else if(m.find()!=true ){
            this.addFieldError("phone", "手机号为1开头的11位数字");
        }
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public String getMsg_u() {
		return msg_u;
	}
	public void setMsg_u(String msg_u) {
		this.msg_u = msg_u;
	}
	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public UserEntity getModel() {
		return user;
	}

}
