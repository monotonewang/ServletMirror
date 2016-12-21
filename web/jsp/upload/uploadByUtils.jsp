<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/20
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadByUtils</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ServletUploadByUtil" method="post" encType="multipart/form-data">
    <input type="text" name="content"><br>
    <input type="file" name="f"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
