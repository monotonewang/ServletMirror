<%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/23
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<table>
    <form action="${pageContext.request.contextPath}/ServletResUpLoad" method="post" encType="multipart/form-data">
        <tr>
            <td>选择上传文件</td>
            <td><input type="file" name="filePath"></td>
        </tr>
        <tr>
            <td>文件描述</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td>上传</td>
            <td><input type="submit" value="上传"></td>
        </tr>
    </form>
</table>
</body>
</html>
