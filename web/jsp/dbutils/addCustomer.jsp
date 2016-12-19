<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/19
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addCustomer</title>
</head>
<body>
${requestScope["add.message"]}<br>
<form action="${pageContext.request.contextPath}/add" method="post">
    客户姓名:<input type="text" name="name"><br>
    客户性别:<input type="radio" name="gender" value="男" checked="checked">男<input type="radio" name="gender" value="女">女
    <br>
    客户生日:<input type="text" name="birthday" class="Wdate" onclick="WdatePicker()" readonly="readonly"><br>
    客户电话:<input type="text" name="cellphone"><br>
    客户邮箱:<input type="text" name="email"><br>
    客户爱好:<input type="text" name="preference"><br>
    客户类型:<input type="text" name="type"><br>
    客户备注:<input type="text" name="description"><br>
    <input type="submit" value="添加">
</form>

</body>
<script language="javascript" type="text/javascript"
        src="${pageContext.request.contextPath}/js/dbutils/My97DatePicker/WdatePicker.js"></script>
</html>
