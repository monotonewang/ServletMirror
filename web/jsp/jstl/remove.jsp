<%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/6
  Time: 19:35
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
    request.setAttribute("name", "美美");
    request.removeAttribute("name");
%>

<c:set var="name" value="小凤" scope="page"></c:set>
${ name }

<c:remove var="name" scope="page"/>
${name }

</body>
</html>
