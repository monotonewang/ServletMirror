<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/20
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sessionDestory</title>
</head>
<body>
    <%
        session.invalidate();
//        session.removeAttribute("user");//移除
    %>
    <%
        out.write("sessionDestory");
    %>
</body>
</html>
