<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/25
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript">
        function sendForm() {
            document.getElementById("f").submit();
        }
    </script>
</head>
<body>
<form id="f" action="${pageContext.request.contextPath}/jsp/ajax/login.jsp" method="post">
    <select name="country" onchange="sendForm()">
        <option>请选择国家</option>
        <option value="china">中文</option>
        <option value="us">us</option>
    </select>
</form>
<%
    //    String county = request.getParameter("country");
    String county = request.getHeader("Accept-Language");
    ResourceBundle bundle = null;
//    if ("us".equals(county)) {
    if (county.startsWith("en-US")) {
        bundle = ResourceBundle.getBundle("message", Locale.US);
    } else {
        bundle = ResourceBundle.getBundle("message", Locale.CHINA);
    }
%>
<%= request.getHeader("Accept-Language")%>
<h1><%=bundle.getString("title")%>
</h1>
<form>
    <%=bundle.getString("username") %><input type="text" name="username"><br>
    <%=bundle.getString("password") %><input type="password" name="password"><br>
    <input type="submit" value="<%=bundle.getString("login") %>">
</form>
</body>
</html>
