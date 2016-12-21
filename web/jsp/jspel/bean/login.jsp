<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/6
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h4>表单提交到JSP的页面</h4>
<form action="/ServletMirror/jsp/jspel/bean/success.jsp" method="POST">
    姓名：<input type="text" name="username" /><br/>
    密码：<input type="password" name="password" /><br/>
    <input type="submit" value="登陆"/>
</form>


<h4>表单提交到Servlet程序</h4>
<form action="/ServletMirror/ServletJspELUser" method="POST">
    姓名：<input type="text" name="username" /><br/>
    密码：<input type="password" name="password" /><br/>
    <input type="submit" value="登陆"/>
</form>


<h4>表单提交到Servlet（BeanUtils）程序</h4>
<form action="/ServletMirror/ServletJspELUserBeanUtils" method="POST">
    姓名：<input type="text" name="username" /><br/>
    密码：<input type="password" name="password" /><br/>
    余额：<input type="text" name="money" /><br/>
    生日：<input type="text" name="birthday" /><br/>
    <input type="submit" value="登陆"/>
</form>

</body>
</html>
