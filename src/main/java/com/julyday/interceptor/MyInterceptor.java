package com.julyday.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class MyInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Action action = (Action) invocation.getAction();
		long start = System.currentTimeMillis();
		String result = invocation.invoke();
		long end = System.currentTimeMillis();
		System.out.println("MyInterceptor 拦截"+action.getClass().getName()+"，执行该action时间是"+(end-start));
		return result;
	}

}
