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
import com.txws.model.TypeTable;
import com.txws.service.interfaces.IMenuService;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Results({ @Result(name = "logSuccess", value = "pages/user!home", type = ServletActionRedirectResult.class),
	@Result(name = "success", value = "index.jsp"), })
public class MenuAction extends ActionSupport {
	
	private static final long serialVersionUID = 7293136559505921937L;
	
	@Resource(name="menuService")
	private IMenuService menuService;

	private Object data = new Object();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	List<Object> dataList = new ArrayList<>();
	
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

	//OK
	public String getAllMenuType(){
		List<TypeTable> list = menuService.getMenuTypes();
		for (TypeTable types : list) {
			dataList.add(types.getTypeName());
		}
		data = dataList;
		return SUCCESS;
	}
	
	public String getMenuByType(){
		//TODO 传入typeId
		return SUCCESS;
	}
	
	//OK
	public String getAllMenu(){
		dataMap.put("menus", menuService.getAllMenu());
		data = dataMap;
		return SUCCESS;
	}
	
	public void getActivityMenuImg() {
		List<String> list = menuService.getActivityMenuImg();
//		for (String string : list) {
//			dataList.add(string);
//		}
		for (String string : list) {
			System.out.println(string);
		}
		dataList.addAll(list);
	}
	
}
