<%@ page import="com.demo.servletpath.cookie.MyCookieUtil" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/11/29
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>productcookie</title>
</head>
<body>
<img src="../../img/1.jpg"><a href="/ServletMirror/servletproductcookie?id=1"><font color="red">手电筒</font></a>
<img src="../../img/2.jpg"><a href="/ServletMirror/servletproductcookie?id=2">手机</a>
<img src="../../img/3.jpg"><a href="/ServletMirror/servletproductcookie?id=3">台式电脑</a>
<img src="../../img/4.jpg"><a href="/ServletMirror/servletproductcookie?id=4">电冰箱</a>
<img src="../../img/5.jpg"><a href="/ServletMirror/servletproductcookie?id=5">手表</a>
<img src="../../img/6.jpg"><a href="/ServletMirror/servletproductcookie?id=6">笔记本电脑</a>
<h1>slect img</h1>
<%
    // 获取cookie中的value，1,2,3	循环遍历，
    Cookie[] cookies = request.getCookies();
    // 查找指定名称的cookie
    Cookie cookie = MyCookieUtil.getCookieByName(cookies, "product");
    // 如果cookie不为空，拿到值，遍历
    if (cookie != null) {
        // 获取值	1,2,3
        String value = cookie.getValue();
        // 分隔
        String[] ids = value.split("x");
        System.out.println(Arrays.toString(ids));
        // 循环遍历，获取id
        for (String id : ids) {

%>

<img class="img2" src="/ServletMirror/img/<%= id %>.jpg"><br/>
<%
        }
    }
%>
</body>
</html>
