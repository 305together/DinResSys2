package com.txws.action;

import org.apache.struts2.config.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
public class TestAction extends ActionSupport {
	public void test() {
		System.out.println("+++++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++++++");
	}
}
