<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/7
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.wang.com/myfn" prefix="myfn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${ fn:length("abcdefg") }

${ fn:toUpperCase("abcdefg") }

${ myfn:sayHi("小风") }

</body>
</html>
