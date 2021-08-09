package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.povo.UserEntity;
import com.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Controller
@Scope("prototype")

public class userAction extends ActionSupport implements ModelDriven<UserEntity>{
	@Resource(name="userService")
	private UserService us;
	private UserEntity user = new UserEntity();
	private String userid;
	private String msg = "";
	private String repassword;
	//用户注册，只允许学生注册
	public String register() {
		if(getUser()!=null)
    	{
			if(user.getSex().equals("0"))
				user.setSex("男");
			else {
				user.setSex("女");
			}
        	us.regist(user);
    		msg = "账号："+user.getUserid()+"已注册！";
    		setUser(null);
        	return SUCCESS;
    	}
    	else{
    		msg = "error";
    		return "fail";
    	}
	}
	//学生修改个人信息
	public String userUpdate() {
		if(user!=null){
			if(user.getSex().equals("0"))
				user.setSex("男");
			else {
				user.setSex("女");
			}
			us.update(user);
			msg = "您的信息已修改！";
			setUserid(user.getUserid());
			return SUCCESS;
		}
		else{
			msg = "error";
			return "fail";
		}
	}
	//学生修改信息校验
	public void validateUserUpdate(){
		Pattern p = Pattern.compile("^1\\d{10}$");  //正则表达匹配手机号
		Matcher m = p.matcher(user.getPhone().trim());
        if(user.getPassword() == null||user.getPassword().equals("")){
            this.addFieldError("password", "密码不能为空");
        }else if(user.getPhone() == null||user.getPhone().equals("")){
            this.addFieldError("phone", "手机号不能为空");
        }else if(m.find()!=true ){
            this.addFieldError("phone", "手机号为1开头的11位数字");
        }
    }
	//注册校验
	public void validateRegister(){
		Pattern p = Pattern.compile("^1\\d{10}$");  //正则表达匹配手机号
		Matcher m = p.matcher(user.getPhone().trim());
        if(user.getUserid() == null||user.getUserid().equals("")){
            this.addFieldError("userid", "用户名不能为空");
        }else if(user.getPassword() == null||user.getPassword().equals("")){
            this.addFieldError("password", "密码不能为空");
        }else if(user.getPassword().equals(repassword) == false){
            this.addFieldError("repassword", "两次密码不一致");
        }else if(user.getPhone() == null||user.getPhone().equals("")){
            this.addFieldError("phone", "手机号不能为空");
        }else if(m.find()!=true ){
            this.addFieldError("phone", "手机号为1开头的11位数字");
        }else{
            if(us.findUserById(user.getUserid())!=null){
                this.addFieldError("userid", "对不起！该用户名已被注册");
            }
        }
    }
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public UserEntity getModel() {
		if(user == null){
			user = new UserEntity();
	    }
		return user;
	}
}