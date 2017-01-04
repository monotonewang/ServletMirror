<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2017/1/4
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>perLogin</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ServletLoginPermission" method="post">
    username:<input type="text" name="username">
    password:<input type="password" name="password">
    <input type="submit" value="权限控制登录">
</form>
</body>
</html>
