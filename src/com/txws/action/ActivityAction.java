package com.txws.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.txws.model.ActivityTable;
import com.txws.service.interfaces.IActivityService;
import com.txws.service.interfaces.IMenuService;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Results({
	@Result(name = "successDel", value = "/index.html")
})
public class ActivityAction extends ActionSupport {
	private static final long serialVersionUID = 6887701169383402623L;
	
	@Resource(name="activityService")
	private IActivityService activityService;
	@Resource(name="menuService")
	private IMenuService menuService;
	
	private Object data = new Object();
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private List<Object> dataList = new ArrayList<>();
	
	private ActivityTable activity;
	private int id;

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

	public ActivityTable getActivity() {
		return activity;
	}

	public void setActivity(ActivityTable activity) {
		this.activity = activity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//TODO activity.descri,activity.promotion
	public String addActivity() {
		try {
			activityService.addActivity(activity);
		} catch (Exception e) {
			System.out.println(e.toString());
			dataMap.put("status", 2);
			data = dataMap;
			return SUCCESS;
		}
		dataMap.put("status", 1);
		data = dataMap;
		return SUCCESS;
	}
	
	//TODO test
	public String changeActivity() {
		try {
			activityService.updateActivity(activity);
		} catch (Exception e) {
			dataMap.put("status", 2);
			data = dataMap;
			return SUCCESS;
		}
		dataMap.put("status", 1);
		data = dataMap;
		return SUCCESS;
	}
	
	//TODO 修改return值和路径
	@SuppressWarnings("finally")
	public String delete(){
		try {
			menuService.removeActivity(id);
			activityService.delActivity(id);
		} catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
		}finally{
			return "successDel";
		}
	}
}
