<%@ page import="com.demo.servletpath.jspel.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/6
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<h3>传统方式封装数据</h3>
<%--<%--%>
    <%--// 获取表单的内容--%>
    <%--String username = request.getParameter("username");--%>
    <%--String password = request.getParameter("password");--%>
    <%--// 创建User对象，set设置值--%>
    <%--User user = new User();--%>
    <%--user.setUsername(username);--%>
    <%--user.setPassword(password);--%>
<%--%>--%>

<%--${ user.getUsername}--%>
<%--${ user.getPassword}--%>
<h3>使用jsp方式封装数据</h3>
<!-- 使用jsp的标签封装数据 -->
<jsp:useBean id="u" class="com.demo.servletpath.jspel.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<jsp:getProperty property="username" name="u"/>
<jsp:getProperty property="password" name="u"/>
</body>
</html>
