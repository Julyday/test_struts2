<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>success.jsp</title>
</head>
<body>
	欢迎您：${name}<br><br/>
	网站访问次数：${applicationScope.count}<br><br/>
	session中的值：${sessionScope.session}<br><br/>
	cookie中的值：${cookie.user.value }<br><br/>
	request中的值：${requestScope.message}
</body>
</html>