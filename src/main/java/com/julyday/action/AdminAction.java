package com.julyday.action;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;





import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Namespace("/admin")
@ParentPackage("struts-default")
@ExceptionMappings({
	@ExceptionMapping(exception="java.lang.ArithmeticException", result = "error"),
	@ExceptionMapping(exception="java.io.IOException", result = "ioerror")
})
@Results({@Result(name = "error", location = "/jsp/admin/error.jsp"),
@Result(name = "ioerror", location = "/jsp/admin/ioerror.jsp")})
public class AdminAction extends ActionSupport {	
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Action(value = "index", results = {
			@Result(name = "success", location = "/jsp/admin/index.jsp")})
	public String index(){
		return SUCCESS;
	}
	
	@Action(value = "login", results = {
			@Result(name = "success", location = "/jsp/admin/success.jsp"),
			@Result(name = "input", location = "/jsp/admin/input.jsp")})
	public String login() throws IOException {
		System.out.println("AdminAction login()");
		//int i = 1/0;
//		int j = 10;
//		if( j == 10){
//			throw new IOException();
//		}
		//如果cookie中有返回input，其他返回success
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] coolies = request.getCookies();
		for(Cookie c : coolies){
			if("admin".equals(c.getName())){
				return INPUT;
			}
		}
		Cookie c = new Cookie("admin",name);
		c.setMaxAge(100);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.addCookie(c);
		return SUCCESS;
	}

}
