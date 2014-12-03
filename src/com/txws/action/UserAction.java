package com.txws.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.txws.model.AddressTable;
import com.txws.model.UserTable;
import com.txws.service.interfaces.IUserService;
import com.txws.util.MD5;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2761694876354016692L;

	@Resource(name = "userService")
	private IUserService userService;
	private UserTable user;
	private AddressTable address1;
	private AddressTable address2;
	//private Map<String, Object> dataMap = new HashMap<String, Object>();
	private List<Object> dataMap = new ArrayList<>();

	public AddressTable getAddress1() {
		return address1;
	}

	public void setAddress1(AddressTable address1) {
		this.address1 = address1;
	}

	public AddressTable getAddress2() {
		return address2;
	}

	public void setAddress2(AddressTable address2) {
		this.address2 = address2;
	}

/*	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}*/

	public List<Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(List<Object> dataMap) {
		this.dataMap = dataMap;
	}

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
		user = userService.loadUser(2);
		return "success";
	}

	/*
	 * public String login() { user.setPassword(MD5.UseMD5(user.getName() +
	 * user.getPassword())); User u = userService.login(user);
	 * 
	 * ActionContext ac = ActionContext.getContext(); Map<String, Object>
	 * session = ac.getSession(); if (u != null) { List<String> authList = new
	 * ArrayList<String>(); try { System.out.println(u.getUserId() +
	 * "=======!!!!!" ); authList = userService.loadAuthorities(u.getRoleId());
	 * for (String string : authList) { System.out.println(string + "=======" );
	 * } } catch (Exception e) { e.printStackTrace(); } session.put("user", u);
	 * session.put("auth", authList); return "logSuccess"; } else{ errorString =
	 * "用户名或密码错误！"; session.put("user", null); return "logFail"; } }
	 * 
	 * public String home(){ return "success"; }
	 */
	/*
	 * public void loadUser() throws IOException { HttpServletResponse
	 * response=ServletActionContext.getResponse(); //以下代码从JSON.java中拷过来的
	 * response.setContentType("text/html"); PrintWriter out; out =
	 * response.getWriter(); Map<String, Object> map = new HashMap<String,
	 * Object>(); map.put("result", true); JSONObject jsonObject =
	 * JSONObject.fromObject(map); out.print(jsonObject.toString());
	 * out.flush(); out.close(); }
	 */
	/*
	 * public String addUser(){ user.getAddress().add(address1);
	 * user.getAddress().add(address2); address1.setUser(user);
	 * address2.setUser(user); try { userService.addUser(user); } catch
	 * (Exception e) { return "logFail"; } return SUCCESS; }
	 * 
	 * public String delUser(){ userService.delUser(user); return SUCCESS; }
	 * 
	 * public String addAddress(){ address1.setUser(user);
	 * userService.addAddress(address1); return SUCCESS; }
	 */

	public String loadUser() throws IOException {
		dataMap.clear();
		for(int i = 1; i < 4; i++){
		user = userService.loadUser(i);
		dataMap.add(user);}
		/*dataMap.put("result", true);
		dataMap.put("user", user);*/
		//JSONObject jsonObject = JSONObject.fromObject(dataMap);
		
		return SUCCESS;
	}
}
