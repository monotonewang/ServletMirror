<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/5
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sessionlogin</title>
</head>
<body>
<form action="/ServletMirror/LoginSessionServlet" method="post">
    <table border="1" width="70%">
        <tr>
            <td>输入姓名</td>
            <td>
                <input type="text" name="username" />
            </td>
        </tr>
        <tr>
            <td>输入密码</td>
            <td>
                <input type="password" name="password" />
            </td>
        </tr>
        <tr>
            <td>验证码</td>
            <td>
                <input type="text" name="code" />
                <img id="imgId" src="/ServletMirror/CheckcodeSessionServlet">
                <a href="#" onclick="run()">看不清，换一张</a>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登陆"/>
            </td>
        </tr>
    </table>
</form>
</body>
<script type="text/javascript">
    // 看不清，换一张，时间戳
    function run(){
        // 获取图片
        var image = document.getElementById("imgId");
        image.src = "/ServletMirror/CheckcodeSessionServlet?"+new Date().getTime();
    }

</script>
</html>
