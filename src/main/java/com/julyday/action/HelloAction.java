package com.julyday.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class HelloAction extends ActionSupport{
	
	public String execute(){
		System.out.println("HelloAction execute()...");
		//int i = 1/0;
		return "success";
	}
}
