<%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/6
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h4>传统方式</h4>
<%= "Hello" %>
<%
    int a = 10;
    request.setAttribute("name", "xy");
%>
<%= a %>


<h4>JSTL的方式 </h4>
<c:out value="Hello"></c:out>
<c:out value="${name }"></c:out>
<!-- "" -->
<c:out value="${ city }" default="北京"></c:out>
<c:out value="<a href='#'>超链接</a>" escapeXml="false"/>

</body>
</html>
