<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.demo.servletpath.jspel.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/6
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>遍历数组</h4>
<%
    String[] arrs = {"美美", "小凤", "芙蓉", "小苍"};
    request.setAttribute("arrs", arrs);
%>
<!-- for(String s : arrs){ }  -->
<c:forEach var="s" items="${ arrs }">
    ${ s }
</c:forEach>

<h4>遍历集合</h4>
<%
    List<String> list = new ArrayList<String>();
    list.add("美美");
    list.add("小凤");
    list.add("芙蓉");
    list.add("小泽");
    request.setAttribute("list", list);
%>
<c:forEach var="s" items="${ list }">
    ${ s }
</c:forEach>
<h4>遍历Map集合</h4>
<%
    Map<String, String> map = new HashMap<>();
    map.put("aa","美美");
    map.put("bb","小强");
    map.put("cc","小明");
    request.setAttribute("map",map);
%>
<c:forEach var="entity" items="${map}">
    ${ user.username } -- ${ user.password }
</c:forEach>
<h4>遍历对象的集合</h4>
<%
    List<User> listUser=new ArrayList<>();
    listUser.add(new User(""));
%>
</body>
</html>
