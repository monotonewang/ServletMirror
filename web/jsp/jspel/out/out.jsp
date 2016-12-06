<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/6
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out</title>
</head>
<body>
    <!-- BBBB HELLO AAAA CCCC -->
    <%= "HELLO" %>
    <% out.print("AAAA"); %>
    <% response.getWriter().print("BBBB"); %>
    <% out.print("CCCC"); %>
</body>
</html>
