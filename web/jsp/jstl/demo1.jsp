<%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/6
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>传统方式</h4>
<%
    int a = 10;
    if(a == 10){
%>
<%= a = 10 %>
<%

    }
%>

<h4>使用jstl的方式</h4>
<c:set var="i" value="10" scope="page" ></c:set>
<c:if test="${ i eq 10 }">
    <font>i = 10</font>
</c:if>

</body>
</html>
