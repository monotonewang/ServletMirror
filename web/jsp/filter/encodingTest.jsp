<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/23
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>encodingTest</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/ServletEncodingTest" method="post">
        <input type="text" name="username"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="commit"><br>
    </form>
</body>
</html>
