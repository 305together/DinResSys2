package com.txws.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.config.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.txws.model.AddressTable;
import com.txws.model.UserTable;
import com.txws.service.interfaces.IAddressService;
import com.txws.service.interfaces.IUserService;
import com.txws.util.MD5;
import com.opensymphony.xwork2.ActionContext;
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
	@Resource(name = "addressService")
	private IAddressService addressService;
	private UserTable user;
	private AddressTable address;
	private Object data;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private List<Object> dataList = new ArrayList<>();

	public UserTable getUser() {
		return user;
	}

	public void setUser(UserTable user) {
		this.user = user;
	}

	public AddressTable getAddress() {
		return address;
	}

	public void setAddress(AddressTable address) {
		this.address = address;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String execute() {
		user = userService.loadUser(2);
		return "success";
	}

	// OK
	public String getLoginStatus() {
		dataMap.clear();

		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		if (session.containsKey("user")) {
			user = (UserTable) session.get("user");
			if (user != null) {
				dataMap.put("status", 1);
			} else
				dataMap.put("status", 2);
		} else {
			dataMap.put("status", 2);
		}
		
		data = dataMap;
		return SUCCESS;
	}

	// OK
	public String register() {
		dataMap.clear();

		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();

		user.setPassword(MD5.UseMD5(user.getName() + user.getPassword()));

		try {
			user.getAddressTable().add(address);
			address.setUserTable(user);

			if (!userService.addUser(user)) {
				dataMap.put("status", 2);
			} else {
				dataMap.put("status", 1);
			}
		} catch (Exception e) {
			dataMap.put("status", 3);
			session.put("user", null);
			return SUCCESS;
		}

		session.put("user", user);
		data = dataMap;
		return SUCCESS;
	}

	//OK
	public String getUserInfo() {
		dataMap.clear();
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		List<Map<String, Object>> list = new ArrayList<>();

		user = (UserTable) session.get("user");

		user = userService.loadUser(user.getId());

		dataMap.put("phone", user.getTel());
		
		for (AddressTable addressTable : user.getAddressTable()) {
			if (addressTable.getIsDefault() == 1) {
				Map<String, Object> temp = new HashMap<>();
				temp.put("id", addressTable.getId());
				temp.put("address", addressTable.getAd());
				temp.put("isDefault", true);
				list.add(temp);
				break;
			}
		}
		for (AddressTable addressTable : user.getAddressTable()) {
			if (addressTable.getIsDefault() != 1) {
				Map<String, Object> temp = new HashMap<>();
				temp.put("id", addressTable.getId());
				temp.put("address", addressTable.getAd());
				temp.put("isDefault", false);
				list.add(temp);
			}
		}

		dataMap.put("addresses", list);

		data = dataMap;
		return SUCCESS;
	}

	// OK
	public String login() {
		dataMap.clear();
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();

		user.setPassword(MD5.UseMD5(user.getName() + user.getPassword()));

		try {
			user = userService.login(user);
			if (user != null)
				dataMap.put("status", 1);
			else
				dataMap.put("status", 2);

		} catch (Exception e) {
			dataMap.put("status", 3);
			session.put("user", null);
			return SUCCESS;
		}

		session.put("user", user);
		
		data = dataMap;
		return SUCCESS;
	}
	
	//TODO test
	public String deleteUser(){
		try {
			user = userService.loadUser(user.getId());
			userService.delUser(user);
		} catch (Exception e) {
			dataMap.put("status", 2);
			data = dataMap;
			return SUCCESS;
		}
		dataMap.put("status", 1);
		data = dataMap;
		return SUCCESS;
	}
}
