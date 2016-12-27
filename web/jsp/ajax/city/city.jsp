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
        var jsonObj;
        window.onload = function () {
            var province = document.getElementById("province");//省份下拉框
            province.innerHTML = "<option>--请选择省份--</option>";
            var city = document.getElementById("city");//城市下拉框.

            //每一次向城市中添加信息时，将信息重置。
            city.innerHTML = "<option>--请选择城市--</option>";
            //1.首先获取xmlhttpRequest对象
            var xmlhttp = getXmlHttpRquest();
            //2.设置回调函数
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    jsonObj = eval("(" + xmlhttp.responseText + ")");

                    //得到省份名称
                    for (var i = 0; i < jsonObj.length; i++) {
                        var pname = jsonObj[i].name;

                        var option = document.createElement("option");
                        option.text = pname;

                        province.add(option);
                    }
                }
            };
            xmlhttp.open("GET", "http://localhost:8080/ServletMirror/ServletAjaxCity", true);
            xmlhttp.send(null);
        }

        function fillCity() {

            var province = document.getElementById("province");//省份下拉框
            var city = document.getElementById("city");//城市下拉框.

            //每一次向城市中添加信息时，将信息重置。
            city.innerHTML = "<option>--请选择城市--</option>";

            var pname = province.options[province.selectedIndex].text;

            for (var i = 0; i < jsonObj.length; i++) {
                var pElementName = jsonObj[i].name;

                if (pname == pElementName) {
                    var citys = jsonObj[i].citys;

                    for (var j = 0; j < citys.length; j++) {

                        var cname = citys[j].name;

                        var option = document.createElement("option");
                        option.text = cname;

                        city.add(option);

                    }
                }
            }
        }

    </script>
</head>
<body>
<select id="province" name="pro" onchange="fillCity()">
    <option value=""></option>
</select><br>
<select id="city" name="city">
    <option value=""></option>
</select>
</body>
</html>
