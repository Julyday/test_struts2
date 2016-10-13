package com.julyday.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DefaultClassRefAction extends ActionSupport{
	
	public String execute(){
		System.out.println("DefaultClassRefAction execute()...");
		return "index";
	}
}
