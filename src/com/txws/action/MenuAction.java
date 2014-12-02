package com.txws.action;

import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Results({ @Result(name = "logSuccess", value = "pages/user!home", type = ServletActionRedirectResult.class),
		@Result(name = "success", value = "index.jsp"),
		@Result(name = "loadSuccess", value = "pages/changeEmployeeInfo.jsp"),
		@Result(name = "logFail", value = "index.jsp"), })
public class MenuAction extends ActionSupport {
	public @ResponseBody String getAllMenuType(){
		return "";
	}
}
