<%@ page import="java.io.File" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.Queue" %><%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/23
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用队列来完成下载upload目录下所有文件</title>
</head>

<body>


<!-- 使用队列操作 -->

<%
    String path = "C:\\upload";
    File uploadDirectory = new File(path);
    //创建一个队列

    Queue<File> queue = new LinkedList<File>();

    queue.offer(uploadDirectory);

    while (!queue.isEmpty()) { //如果队列不为空
        File f = queue.poll(); //从队列中获取一个File

        if (f.isDirectory()) {//是目录,将目录下所有文件遍历出来，存储到队列中
            File[] fs = f.listFiles();

            for (int i = 0; i < fs.length; i++) {
                queue.offer(fs[i]);
            }
        } else {
            String absolutePath = (f.getAbsolutePath());

            String p = absolutePath.substring(absolutePath.lastIndexOf("\\upload"));

            out.println("<a href='/ServletMirror" + p + "'>" + f.getName() + "</a><br>");
        }

    }
%>


</body>
</html>


