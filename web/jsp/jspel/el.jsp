<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/11/29
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%!
    int a=10;
    %>
<%=a %>
<%
    int b=100;
    if(b==10){

    }else{

    }
%>

<table border="1" width="60%">

    <%
        for(int i=1;i<=10;i++){

    %>
    <tr>
        <%
            for(int j=1;j<=10;j++){

        %>
        <td>1</td>
        <%

            }

        %>
    </tr>
    <%

        }

    %>


</table>



<%

    request.setAttribute("aa", "苍老师");

%>

<%= request.getAttribute("aa") %>

${ aa }
</body>
</html>
