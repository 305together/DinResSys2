package com.txws.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.config.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.txws.model.AddressTable;
import com.txws.model.UserTable;
import com.txws.service.interfaces.IAddressService;
@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
public class AddressAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7905547754068502570L;
	
	@Resource(name="addressService")
	private IAddressService addressService;
	
	private Object data = new Object();
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private List<Object> dataList = new ArrayList<>();
	private AddressTable address;
	private UserTable user;
	
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
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

	//OK
	public String setDefaultAddress(){
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		user = (UserTable) session.get("user");
		
		if(user == null){
			dataMap.put("status", 3);
		}else {
			address = addressService.loadAddress(address.getId());
			address.setIsDefault(1);
			try {
				addressService.setDefaultAddress(address,user.getId());
			} catch (Exception e) {
				dataMap.put("status", 2);
				data = dataMap;
				return SUCCESS;
			}
			dataMap.put("status", 1);
		}
		data = dataMap;
		return SUCCESS;
	}
	
	//OK
	public String addAddress(){
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		user = (UserTable) session.get("user");
		
		if(user == null){
			dataMap.put("status", 3);
		}else {
				address.setUserTable(user);
			try {
				addressService.addAddress(address);
			} catch (Exception e) {
				dataMap.put("status", 2);
				data = dataMap;
				return SUCCESS;
			}
			dataMap.put("status", 1);
		}
		data = dataMap;
		return SUCCESS;
	}
}
