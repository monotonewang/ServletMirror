<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/20
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>多文件上传</title>

    <script type="text/javascript">

        function addFile() {
            var div = document.getElementById("content");

            div.innerHTML += "<div><input type='file' name='f'><input type='button' value='remove file' onclick='removeFile(this)'></div>";
        }

        function removeFile(btn) {

            document.getElementById("content").removeChild(btn.parentNode);

        }
    </script>

</head>

<body>

<input type="button" value="add File" onclick="addFile();">
<br>
<br>
<form action="${pageContext.request.contextPath}/ServletUploadFilename" method="post" encType="multipart/form-data">
    <input type="file" name="f"><br>
    <div id="content">
    </div>
    <input type="submit" value="上传">
</form>
</body>
</html>
