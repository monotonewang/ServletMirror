<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/22
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userLogin</title>
</head>
<body>
${ requestScope.get("login.msg") }
    <form action="${pageContext.request.contextPath}/ServletUserFilterLogin" method="post">
        username：<input type="text" name="username"><br>
        password:<input type="password" name="password"><br>
        <input type="checkbox" name="autoLogin">auto login<br>
        <input type="submit" value="login">
    </form>
</body>
</html>
