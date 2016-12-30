<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/30
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" about="center">
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>role</td>
    </tr>

    <c:forEach items="${user}" var="c">
        <tr>
            <td>${c.id+""}</td>
            <td>${c.username}</td>
            <td>${c.password}</td>
            <td>${c.role}</td>
        </tr>
    </c:forEach>

</table>
<a href="${pageContext.request.contextPath}/ServletExcelPrint">导出Excel</a>
</body>
</html>
