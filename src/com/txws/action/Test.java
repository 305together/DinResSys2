package com.txws.action;

import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Results({
// @Result(name="success",value="districts",params={"contentType","text/plain","root","districts","excludeNullProperties","true"},type=JSONResult.class),
		@Result(name = "printRoleList", value = "pages/roleMgr.jsp"), 
		@Result(name = "success", value = "base!getAllRole",  type = ServletActionRedirectResult.class), 
})
public class Test {

}
