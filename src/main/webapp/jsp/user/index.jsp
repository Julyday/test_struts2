<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index.jsp</title>
<script type="text/javascript">
	function regist(){
		var targetForm = document.forms[0];
		//targetForm.action = "login!regist";
		targetForm.action = "regist_Login";
	}
</script>
</head>
<body>
	<form action="login_Login" method="post">
		<div style="margin-left: 300px;margin-top: 200px">
			姓名：<input name="name" type="text"/><br></br>
			密码：<input name="password" type="password"/><br></br>
			<input type="submit" value="登录"/><input type="submit" value="注册" onclick="regist()" style="margin-left: 50px"/>
		</div>
	</form>

</body>
</html>