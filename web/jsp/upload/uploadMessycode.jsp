<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/20
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadMessyCode</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/ServletUploadMessycode" method="post" encType="multipart/form-data">
        <input type="text" name="content"><br>
        <input type="file" name="f"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
