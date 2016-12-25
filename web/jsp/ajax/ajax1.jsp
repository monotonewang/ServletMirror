<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>ajax开发步骤</title>

    <script type="text/javascript">

        //第一步:得到XMLHttpRequest对象.
        var xmlhttp = null;

        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest(); //针对于现在的浏览器包括IE7以上版本
        } else if (window.ActiveXObject) {
            //针对于IE5,IE6版本
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        //2.设置回调函数
        xmlhttp.onreadystatechange = function () {

            //5.处理响应数据  当信息全部返回，并且是成功
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

                alert(xmlhttp.responseText);
            }
        };

        //3.open
        //	xmlhttp.open("GET","http://localhost:8080/ServletMirror/ServletAjax");
        xmlhttp.open("GET", "http://localhost:8080/ServletMirror/ServletAjax?name=tom");

        //4.发送请求 send
        //	xmlhttp.send(null);
        //Post请求参数 如果是post方式需要设置请求头
        xmlhttp.open("POST", "http://localhost:8080/ServletMirror/ServletAjax");
        xmlhttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        xmlhttp.send("name=tom");
    </script>

</head>

<body>
This is my JSP page.
<br>
</body>
</html>
