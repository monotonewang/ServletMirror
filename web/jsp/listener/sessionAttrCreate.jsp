<%@ page import="com.demo.servletpath.listener.bean.ListenerUser" %><%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/20
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SeesionAttrCreate</title>
</head>
<body>
    <%
        session.setAttribute("sname", "svalue"); //添加

        session.setAttribute("sname", "sssss"); //修改

        session.removeAttribute("sname"); //移除
    %>
        <%
            out.write("SeesionCreate");
        %>
</body>
</html>
