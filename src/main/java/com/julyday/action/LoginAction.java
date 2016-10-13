package com.julyday.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ServletRequestAware{
	
	private String name;
	private String password;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String execute() {
		//获取页面参数值的四种方式：
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req1 = ServletActionContext.getRequest();
		System.out.println("ServletActionContext 方式："+req1.getParameter("name"));
		HttpServletRequest req2 = (HttpServletRequest) ctx.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		System.out.println("ActionContext 方式：" + req2.getParameter("name"));
		System.out.println("set 方式："+name);
		System.out.println("ServletRequestAware 方式:"+request.getParameter("name"));
		
		//向Application中添加属性
		Integer count = (Integer)ctx.getApplication().get("count");
		if(count == null){
			count = 1;
		}else{
			count++;
		}
		ctx.getApplication().put("count", count);
		
		//向Session中添加属性
		ctx.getSession().put("session", name);
		//向Cookie中添加属性
		Cookie c = new Cookie("user",password);
		c.setMaxAge(3600);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.addCookie(c);
		
		//向request中添加属性
		ctx.put("message", "登录成功");
		return SUCCESS;
	}
	
	public String login() {
		//获取页面参数值的四种方式：
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req1 = ServletActionContext.getRequest();
		System.out.println("ServletActionContext 方式："+req1.getParameter("name"));
		HttpServletRequest req2 = (HttpServletRequest) ctx.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		System.out.println("ActionContext 方式：" + req2.getParameter("name"));
		System.out.println("set 方式："+name);
		System.out.println("ServletRequestAware 方式:"+request.getParameter("name"));
		
		//向Application中添加属性
		Integer count = (Integer)ctx.getApplication().get("count");
		if(count == null){
			count = 1;
		}else{
			count++;
		}
		ctx.getApplication().put("count", count);
		
		//向Session中添加属性
		ctx.getSession().put("session", name);
		//向Cookie中添加属性
		Cookie c = new Cookie("user",password);
		c.setMaxAge(3600);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.addCookie(c);
		
		//向request中添加属性
		ctx.put("message", "登录成功");
		return SUCCESS;
	}
	
	public String regist() {
		System.out.println("LoginAction regist()...");
		Cookie c = new Cookie("name",name);
		c.setMaxAge(3600);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.addCookie(c);
		return "regist";
	}
}
