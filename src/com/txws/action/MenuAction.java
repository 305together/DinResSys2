
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
import com.txws.model.MenuTable;
import com.txws.model.TypeTable;
import com.txws.service.interfaces.IAppraiseService;
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
	@Resource(name="appraiseService")
	private IAppraiseService appraiseService;

	private Object data = new Object();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	List<Object> dataList = new ArrayList<>();
	private MenuTable menuTable;
	
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

	public MenuTable getMenuTable() {
		return menuTable;
	}

	public void setMenuTable(MenuTable menuTable) {
		this.menuTable = menuTable;
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
	
	//OK
	public String getAllMenu(){
		dataMap.put("menus", menuService.getAllMenu());
		data = dataMap;
		return SUCCESS;
	}
	
	public String getActivityMenuImg() {
		List<Object> list = (List<Object>) menuService.getActivityMenuImg();
		data = list;
		return SUCCESS;
	}
	
	//TODO test,input menuId
	public String deleteMenu() {
		int menuId = 19;
		try {
			MenuTable menuTable = menuService.getMenuById(menuId);
			menuService.deleteMenu(menuTable);
			appraiseService.deleteAppraiseByMenu(menuId);
		} catch (Exception e) {
			System.err.println(e.toString());
			dataMap.put("status", 2);
			data = dataMap;
			return SUCCESS;
		}
		dataMap.put("status", 1);
		data = dataMap;
		return SUCCESS;
	}
	
	//TODO test,upload picture
	public String addMenu() {
		int typeId = 1;
		try {
			menuService.addMenu(menuTable,typeId);
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
