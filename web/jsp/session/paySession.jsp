<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/5
  Time: 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结算</title>
</head>
<body>
        <%
            //显示商品信息和数量
            HttpSession session1 = request.getSession();
            Map<String, Integer> cartMap2 = (HashMap<String, Integer>) session1.getAttribute("cart");
            if (cartMap2 != null) {
                Set<String> keys = cartMap2.keySet();
                for (String key : keys) {
        %>
        <h3>亲，你购买的商品<%=key%>数量<%=cartMap2.get(key)%>
        </h3>
        <%
            }
        } else {
            response.getWriter().write("购物车为空");
        %>
        <h3>请继续购物<a href='/ServletMirror/jsp/cartSession.jsp'>购物</a></h3>
        <%
            }

        %>
</body>
</html>
