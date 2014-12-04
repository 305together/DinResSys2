package com.txws.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.config.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.txws.service.interfaces.IAppraiseService;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
public class AppraiseAction {
	
	@Resource(name="appraiseService")
	private IAppraiseService appraiseService;
	
	Map<String, Object> dataMap = new HashMap<String, Object>();
	
	public void getAppraiseByMenuID(int menuId) {
		Map<String, Object> map = appraiseService.getAppraiseByMenuID(menuId);
		dataMap.putAll(map);
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
}
