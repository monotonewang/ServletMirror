<%--
  Created by IntelliJ IDEA.
  User: WangTest
  Date: 2016/12/19
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="pagetag" uri="http://www.wang.com/pagetag" %>

<html>
<script type="application/javascript">
    function changeCurrentPage(value) {
//        alert(value);
        location.href = "/ServletMirror/ServletFindByPage?currentPage=" + value;
    }
</script>
<head>
    <title>分页操作</title>
</head>
<body>

<c:if test="${empty pb.customerList}">
    无客户信息
</c:if>


<c:if test="${not empty pb.customerList}">

    <table border="1" align="center" width="85%">
        <tr>

            <td>客户编号</td>
            <td>客户姓名</td>
            <td>客户性别</td>
            <td>客户生日</td>
            <td>客户电话</td>
            <td>客户邮箱</td>
            <td>客户爱好</td>
            <td>客户类型</td>
            <td>客户备注</td>

        </tr>

        <c:forEach items="${pb.customerList}" var="c">
            <tr>

                <td>${c.id }</td>
                <td>${c.name}</td>
                <td>${c.gender }</td>
                <td>${c.birthday }</td>
                <td>${c.cellphone }</td>
                <td>${c.email }</td>
                <td>${c.preference }</td>
                <td>${c.type }</td>
                <td>${c.description }</td>

            </tr>
        </c:forEach>
        <tr>
            <td colspan="9" align="center"><a
                    href="/ServletMirror/ServletFindByPage?pageNum=1&currentPage=${pb.currentPage}">首页</a>&nbsp;&nbsp;&nbsp;

                <c:if test="${pb.pageNum==1}">
                    上一页&nbsp;&nbsp;&nbsp;
                </c:if> <c:if test="${pb.pageNum!=1}">
                    <a href="/ServletMirror/ServletFindByPage?pageNum=${pb.pageNum-1}&currentPage=${pb.currentPage}">上一页</a>&nbsp;&nbsp;&nbsp;
                </c:if> <c:if test="${pb.pageNum==pb.totalPage}">
                    下一页&nbsp;&nbsp;&nbsp;
                </c:if> <c:if test="${pb.pageNum!=pb.totalPage}">
                    <!--防止选择了分页条数，点击下一页出错。带过去currentPage-->
                    <a href="/ServletMirror/ServletFindByPage?pageNum=${pb.pageNum+1 }&currentPage=${pb.currentPage}">下一页</a>&nbsp;&nbsp;&nbsp;
                </c:if>
                <a href="/ServletMirror/ServletFindByPage?pageNum=${pb.totalPage }&currentPage=${pb.currentPage}">尾页</a>&nbsp;&nbsp;&nbsp;

                <select name="currentPage"
                        onchange="changeCurrentPage(this.value);">
                    <option>--请选择每页条数--</option>
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="20">20</option>
                </select>
            </td>

        </tr>
        <tr>
            <td colspan="9" align="center">
                <c:forEach begin="1" end="${pb.totalPage}" var="n" step="1">
                    <c:if test="${n==pb.pageNum}">
                        <a href="/ServletMirror/ServletFindByPage?pageNum=${n}&currentPage=${pb.currentPage}"><font
                                color='red'>第${n}页</font> </a>&nbsp;&nbsp;
                    </c:if>

                    <c:if test="${n!=pb.pageNum}">
                        <a href="/ServletMirror/ServletFindByPage?pageNum=${n}&currentPage=${pb.currentPage}">第${n}页</a>&nbsp;&nbsp;

                    </c:if>
                </c:forEach>
            </td>
        </tr>
        <!--自定义标签-->
        <tr>
            <td colspan="9" align="center"><pagetag:page pb="${pb}"/>
            </td>
        </tr>
    </table>


</c:if>


</body>
</html>
