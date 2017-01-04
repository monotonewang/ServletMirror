<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2017/1/4
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book</title>
</head>
<body>
当前用户：${user.username}
<br>
<a href="${pageContext.request.contextPath}/ServletBooks?method=add">add book</a>
<a href="${pageContext.request.contextPath}/ServletBooks?method=update">update book</a>
<a href="${pageContext.request.contextPath}/ServletBooks?method=delete">delete book</a>
<a href="${pageContext.request.contextPath}/ServletBooks?method=search">search book</a>
</body>
</html>
