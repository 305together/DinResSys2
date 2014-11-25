package com.txws.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.txws.model.UserTable;
import com.txws.service.interfaces.IUserService;
import com.txws.util.MD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Results({ @Result(name = "logSuccess", value = "pages/user!home", type = ServletActionRedirectResult.class),
		@Result(name = "success", value = "home.jsp"),
		@Result(name = "loadSuccess", value = "pages/changeEmployeeInfo.jsp"),
		@Result(name = "logFail", value = "index.jsp"), })
public class UserAction extends ActionSupport {

	@Resource(name = "userService")
	private IUserService userService;
	
	private UserTable user;
	private String errorString;
	
	public UserTable getUser() {
		return user;
	}

	public void setUser(UserTable user) {
		this.user = user;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

	public String execute() {
		return SUCCESS;
	}

	public String login() {
		user.setUserPw(MD5.UseMD5(user.getUserPw()));
		UserTable u = userService.login(user);

		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		if (u != null) {
			List<String> authList = new ArrayList<String>();
			try {
				System.out.println(u.getUserId() + "=======!!!!!" );
				authList = userService.loadAuthorities(u.getRoleId());
				for (String string : authList) {
					System.out.println(string + "=======" );
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.put("user", u);
			session.put("auth", authList);
			return "logSuccess";
		} else{
			errorString = "用户名或密码错误！";
			session.put("user", null);
			return "logFail";
		}
	}
	
	public String home(){
		return "success";
	}
	
	public String loadUser() {
		user = userService.loadUser(user.getUserId());
		return "loadSuccess";
	}
}
