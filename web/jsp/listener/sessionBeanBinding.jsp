<%@ page import="com.demo.servletpath.listener.bean.ListenerUser" %><%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/20
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sessionBeanBinding</title>
</head>
<body>
<%
    ListenerUser user = new ListenerUser();
    user.setId(1);
    user.setName("tom");

    session.setAttribute("user", user); //绑定
%>
</body>
</html>
