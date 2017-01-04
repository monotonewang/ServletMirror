<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2017/1/4
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProxyEncoding</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ServletProxyLogin">
    <input type="text" name="username">
    <input type="submit" value="login">
</form>
</body>
</html>
