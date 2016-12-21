<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>    
<%@ taglib uri="http://www.wang.com/myfn" prefix="myfn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload="run()">
<h4>登陆页面</h4>

<%
	// 获取cookie		%E9%83%AD%E7%BE%8E%E7%BE%8E
	// URLDecoder.decode(username, "UTF-8");
	
	// 编写自定义EL函数
	
%>

<!--${ cookie.username.value }  / %E9%83%AD%E7%BE%8E%E7%BE%8E -->
<!-- 切分     -->

<form action="${pageContext.request.contextPath }/ServletMvpLogin" method="POST">
	<!--  输入姓名：<input type="text" name="username" value="${ cookie.username.value }"/><br/>-->
	<!--输入姓名：<input type="text" name="username" value="${ myfn:decode(cookie.username.value) }"/><br/>-->
	输入姓名：<input type="text" id="nameId" name="username" /><br/>
	输入密码：<input type="password" name="password" /><br/>
	<input type="checkbox" name="remember" value="remember" />记住用户名<br/>
	<input type="submit" value="登陆"/>
</form>
</body>

<script type="text/javascript">
	function run(){
		// 接收cookie的值
		var str = "${ cookie.username.value }";
		// 解码
		var newstr = decodeURI(str);
		// 赋值给文本框
		document.getElementById("nameId").value = newstr;
	}
	
</script>

</html>



