<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/22
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginSuccess</title>
</head>
<body>
    <%--get user login username--%>
    user.username=${user.username}<br>
    <!--url权限控制-->
    <a href="${pageContext.request.contextPath}/ServletFilterBookAdd">book add</a>
    <br>
    <a href="${pageContext.request.contextPath}/ServletFilterBookUpdate">book update</a>
    <br>
    <a href="${pageContext.request.contextPath}/ServletFilterBookDelete">book delete</a>
    <br>
    <a href="${pageContext.request.contextPath}/ServletFilterBookSearch">book search</a>
    <br>
</body>
</html>
