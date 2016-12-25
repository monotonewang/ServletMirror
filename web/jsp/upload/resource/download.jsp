<%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/25
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>download</title>
</head>
<body>

<table border="1" align="center">
    <tr>
        <td>文件名称</td>
        <td>文件描述</td>
        <td>下载操作</td>
    </tr>
    <c:forEach items="${rs}" var="r">
        <tr>
            <td>${r.realName}</td>
            <td>${r.description}</td>
            <td><a href="${pageContext.request.contextPath}/ServletGetDownLoad?id=${r.id}">下载</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
