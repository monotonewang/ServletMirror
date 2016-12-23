<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/20
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>downloadFilename</title>
</head>
<body>
    <a href='${pageContext.request.contextPath}/ServletFileDownLoad?filename=a.bmp'>a.bmp</a><br>
    <a href='${pageContext.request.contextPath}/ServletFileDownLoad?filename=a.doc'>a.doc</a><br>
    <a href='${pageContext.request.contextPath}/ServletFileDownLoad?filename=a.txt'>a.txt</a><br>
    <a href='${pageContext.request.contextPath}/ServletFileDownLoad?filename=天空.mp3'>天空.mp3</a><br>
</body>
</html>
