<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/12
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>transfer money</title>
</head>
<body>
    <table>
        <form action="${pageContext.request.contextPath}/ServletAccount" method="post">
            <tr>
                <td>accountIn</td></td><td><input type="text" name="accountIn"></td>
            </tr>
            <tr>
                <td>accountOut</td></td><td><input type="text" name="accountOut"></td>
            </tr>
            <tr>
                <td>money</td></td><td><input type="text" name="money"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="login" name="login"></td>
            </tr>

        </form>
    </table>
</body>
</html>
