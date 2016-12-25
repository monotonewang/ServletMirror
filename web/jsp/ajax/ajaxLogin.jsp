<%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/25
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login,验证用户名是否可以使用</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jsp/ajax/js/getXmlHttp.js"></script>
    <script type="text/javascript">

        window.onload = function () {
            //得到id =t
            var txt = document.getElementById("t");
            //文本框失去焦点
            txt.onblur = function () {

                var value = txt.value;
                //第一步:得到XMLHttpRequest对象.
                var xmlhttp = getXmlHttpRquest();

                //2.设置回调函数
                xmlhttp.onreadystatechange = function () {

                    //5.处理响应数据  当信息全部返回，并且是成功
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        var msg=xmlhttp.responseText
                        document.getElementById("msg").innerHTML=msg;
//                        alert(msg);
                    }
                };

                //3.open
                //	xmlhttp.open("GET","http://localhost:8080/ServletMirror/ServletAjax");
//                xmlhttp.open("GET", "http://localhost:8080/ServletMirror/ServletAjax?name=tom");

                //4.发送请求 send
                //	xmlhttp.send(null);
                //Post请求参数 如果是post方式需要设置请求头
                xmlhttp.open("POST", "http://localhost:8080/ServletMirror/ServletAjaxLogin");
                xmlhttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
                xmlhttp.send("name=" + value);
            }
        }
    </script>
</head>
<body>
username<input id="t" type="text" name="username"><span id="msg"></span><br>

</body>
</html>
