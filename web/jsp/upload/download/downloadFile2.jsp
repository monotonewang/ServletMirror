<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/23
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用递归来完成下载upload目录下所有文件</title>
</head>

<body>


<!-- 使用递归操作 -->

<%!
    //声明一个方法

    public void getFile(File file) {
        if (file.isDirectory()) {
            //是目录
            File[] fs = file.listFiles();

            for (int i = 0; i < fs.length; i++) {
                getFile(fs[i]); //递归调用
            }

        } else if (file.isFile()) {
            //是文件
            System.out.println(file.getName());
        }
    }
%>


<%
    String path = "C:\\upload";
    File uploadDirectory = new File(path);

    getFile(uploadDirectory);
%>


</body>
</html>
