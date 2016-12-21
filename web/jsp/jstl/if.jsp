<%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/6
  Time: 19:33
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
    int a = 10;
    if(a >= 10){
        out.print("a >= 10");
    }else{
        out.print("a < 10");
    }
%>

<h4>JSTL方式</h4>
<c:set var="i" value="10" scope="page"></c:set>
<c:if test="${ i ge 10 }" var="x" scope="page">
    i >= 10
</c:if>
<c:if test="${ i lt 10 }">
    i < 10
</c:if>

${ x }
</body>
</html>
