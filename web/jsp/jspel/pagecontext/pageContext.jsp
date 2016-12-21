<%--
  Created by IntelliJ IDEA.
  User: 7
  Date: 2016/12/6
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext</title>
</head>
<body>
    <%=request.getParameter("username") %>

    <h4>pageContext向其他域中存入值</h4>
    <%
        pageContext.setAttribute("name", "美美");
        // 下面这句等价于上面
        pageContext.setAttribute("name", "美美", pageContext.PAGE_SCOPE);

        request.setAttribute("name", "小凤");
        // 向request域中存入值
        pageContext.setAttribute("name", "小凤", pageContext.REQUEST_SCOPE);

        // 向session域存入值
        pageContext.setAttribute("name", "小苍", pageContext.SESSION_SCOPE);
        // 向ServletContext域存入值
        pageContext.setAttribute("name", "小班长", pageContext.APPLICATION_SCOPE);

    %>

    <%= pageContext.getAttribute("name", pageContext.SESSION_SCOPE)%>
    <%= session.getAttribute("name") %>


    ${ pageScope.name }
    ${ requestScope.name }
    ${ sessionScope.name }
    ${ applicationScope.name }
</body>
</html>
