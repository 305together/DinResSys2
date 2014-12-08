package com.txws.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.txws.model.AppraiseTable;
import com.txws.service.interfaces.IAppraiseService;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Results({@Result(name = "success", value = "index.jsp"), })
public class AppraiseAction extends ActionSupport {
	
	@Resource(name="appraiseService")
	private IAppraiseService appraiseService;
	
	private Map<String, Object> dataMap;
	
	private int menuId;
	
	public String getAppraiseByMenuID() {
		dataMap = appraiseService.getAppraiseByMenuID(menuId);
		return SUCCESS;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

}
