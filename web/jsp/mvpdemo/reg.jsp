<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/7
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mvpDemoLogin</title>
</head>
<body>
<font color="red">${ requestScope.msg }</font>
<form name="form1"action="/ServletMirror/ServletMvpRegister" method="post" onsubmit="return run()">
    <table>
        <tr>
            <td>username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>repassword</td>
            <td><input type="password" name="repassword"></td>
        </tr>
        <tr>
            <td>nickname</td>
            <td><input type="text" name="nickname"></td>
        </tr>
        <tr>
            <td>email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>imgcode</td>
            <td><input type="text" name="code"></td>
            <a href="#" onclick="show(); return false;"><img id="imgId" src="${ pageContext.request.contextPath }/ServletMvpCheckCode"></a>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="reg"></td>
        </tr>
    </table>
</form>
</body>
<script type="text/javascript">
    // 完成校验
    function run() {
        // 用户名不能为空
        var username = document.form1.username.value;
        if (username == "" || username.length == 0) {
            alert("用户名不能为空");
            return false;
        }
        // 密码不能为空，不能少于6位
        var password = document.form1.password.value;
        if (password == "" || password.length < 6) {
            alert("密码至少6位");
            return false;
        }
        // 确认密码和密码一致
        var repassword = document.form1.repassword.value;
        if (repassword == "" || repassword != password) {
            alert("两次密码不一致");
            return false;
        }
        // 昵称不能为空
        var nickname = document.form1.nickname.value;
        if (nickname == "" || nickname.length == 0) {
            alert("昵称不能为空");
            return false;
        }
        // 邮箱正确的邮箱格式	/.+@.+\.[a-zA-Z]{2,4}$/
        var email = document.form1.email.value;
        if (!/.+@.+\.[a-zA-Z]{2,4}$/.test(email)) {
            alert("邮箱格式不正确");
            return false;
        }
        // 可以提交了
    }

</script>
<script type="text/javascript">
    function show() {
        var image = document.getElementById("imgId");
        image.src = "${pageContext.request.contextPath}/ServletMvpCheckCode?" + new Date().getTime();
    }

</script>
</html>
