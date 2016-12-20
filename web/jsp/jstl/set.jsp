<%@ page import="com.demo.servletpath.jspel.bean.User" %><%--
  Created by IntelliJ IDEA.
  ListenerUser: WangTest
  Date: 2016/12/6
  Time: 19:34
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
<%
    pageContext.setAttribute("name", "10", pageContext.REQUEST_SCOPE);

%>

<%
    User user = new User();
    user.setUsername("美美");
    user.setPassword("123");
    request.setAttribute("user", user);
%>
${ user.username }

<h4>JSTL方式</h4>
<c:set var="i" value="10" scope="request" ></c:set>
${ i }

<c:set target="${ user }" property="username"  value="小凤"></c:set>
${ user.username }
</body>
</html>
