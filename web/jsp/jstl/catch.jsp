<%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/6
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>传统方式</h4>
<%
    try{

    }catch(Exception e){
        e.printStackTrace();
    }
%>
<h4>JSTL的方式</h4>
<c:catch var="e">
    <%
        int a = 10/0;
    %>
</c:catch>
${ e.message }
</body>
</html>
