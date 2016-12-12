<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/12
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>show Customer</title>
</head>
<body>

<c:if test="${empty cs}">
    无客户info
</c:if>
<c:if test="${not empty cs}">
<table border="1" align="center" width="70%">
    <tr>
        <td><input type="checkbox"></td>
        <td>客户编号</td>
        <td>客户姓名</td>
        <td>客户性别</td>
        <td>客户生日</td>
        <td>客户邮箱</td>
        <td>客户电话</td>
        <td>客户爱好</td>
        <td>客户类型</td>
        <td>客户备注</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${cs}" var="c">
        <tr>
            <td><input type="checkbox"></td>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.gender}</td>
            <td>${c.birthday}</td>
            <td>${c.email}</td>
            <td>${c.cellphone}</td>
            <td>${c.type}</td>
            <td>${c.preference}</td>
            <td>${c.description}</td>
            <td><a>编辑</a>&nbsp;<a>删除</a></td>

        </tr>
    </c:forEach>

    </c:if>

</table>
</body>
</html>
