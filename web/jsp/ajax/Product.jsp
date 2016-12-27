<%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/25
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border='1'>
    <tr>
        <td>商品编号</td>
        <td>商品名称</td>
        <td>商品价格</td>
    </tr>
    <c:forEach items="${ps}" var="p">
    <tr>
        <td>${p.id }</td>
        <td>${p.name }</td>
        <td>${p.money }</td>
    </tr>
    </c:forEach>
</body>
</html>
