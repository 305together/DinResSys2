package com.txws.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.txws.model.AddressTable;
import com.txws.model.UserTable;
import com.txws.service.interfaces.IAddressService;
@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Results({ @Result(name = "logSuccess", value = "pages/user!home", type = ServletActionRedirectResult.class),
		@Result(name = "success", value = "index.jsp"),
		@Result(name = "loadSuccess", value = "pages/changeEmployeeInfo.jsp"),
		@Result(name = "logFail", value = "index.jsp"), })
public class AddressAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7905547754068502570L;
	
	@Resource(name="addressService")
	private IAddressService addressService;
	
	Map<String, Object> dataMap = new HashMap<String, Object>();
	List<Object> dataList = new ArrayList<>();
	AddressTable address;
	UserTable user;
	
	public AddressTable getAddress() {
		return address;
	}

	public void setAddress(AddressTable address) {
		this.address = address;
	}

	public UserTable getUser() {
		return user;
	}

	public void setUser(UserTable user) {
		this.user = user;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String execute() {
		return SUCCESS;
	}

	//TODO test
	public String setDefaultAddress(){
		if(user == null){
			dataMap.put("status", 3);
			return "Error";
		}else {
			address.setIsDefault(1);
			try {
				addressService.setDefaultAddress(address);
			} catch (Exception e) {
				dataMap.put("status", 2);
				return "Error";
			}
			dataMap.put("status", 1);
			return SUCCESS;
		}
	}
}
