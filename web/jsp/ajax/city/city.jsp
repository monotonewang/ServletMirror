<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/26
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>city</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jsp/ajax/js/getXmlHttp.js"></script>
    <script type="application/javascript">
        window.onload = function () {
            //1.首先获取xmlhttpRequest对象
            var xmlhttp = getXmlHttpRquest();
            //2.设置回调函数
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var msg = xmlhttp.responseText;
                    var pro = window.document.getElementById("pro");

                    for (var i = 0; i < msg.length; i++) {
                        var option = document.createElement("option");
                        pro.innerHTML = "<option></option>";
                    }
                    alert(msg);
                }
            };
            xmlhttp.open("GET", "http://localhost:8080/ServletMirror/ServletAjaxCity", true);
            xmlhttp.send(null);
        }

        function sendCity() {

        }

        function sendPro() {

        }
    </script>
</head>
<body>
<select id="pro" name="pro" onchange="sendPro()">
    <option value=""></option>
</select><br>
<select id="city" name="city" onchange="sendCity()">
    <option value=""></option>
</select>
</body>
</html>
