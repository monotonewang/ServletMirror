<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/13
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>update user Info</title>

</head>
<%--<c:forEach items="${cs}" var="c">--%>
<%--${cs.id}--%>
<%--${c.id}--%>
<%--</c:forEach>--%>
<body>
<table width="1" border="1">
    <form action="${pageContext.request.contextPath}/ServletUpdateCustomer" method="post">
        <tr>
            <td>userID</td>
            <td><input type="hidden" name="id" value="${cs.id}"></td>
        </tr>
        <tr>
            <td>userName</td>
            <td><input type="text" name="name" value="${cs.name}"></td>
        </tr>

        <tr>
            <td>userGender</td>
            <td><input type="text" name="name" value="${cs.gender}"></td>
        </tr>

        <tr>
            <td>userBrithday</td>
            <td><input type="text" name="birthday" value="${cs.birthday}"></td>
        </tr>
        <tr>
            <td>userCellPhone</td>
            <td><input type="text" name="cellphone" value="${cs.cellphone}"></td>
        </tr>

        <tr>
            <td>userEmail</td>
            <td><input type="text" name="email" value="${cs.email}"></td>
        </tr>

        <tr>
            <td>userPreference</td>
            <td><input type="text" name="preference" value="${cs.preference}"></td>
        </tr>

        <tr>
            <td>userType</td>
            <td><input type="text" name="type" value="${cs.type}"></td>
        </tr>
        <tr>
            <td>userDescription</td>
            <td><input type="text" name="description" value="${cs.description}"></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="update"></td>
        </tr>
    </form>
</table>
</body>
</html>
