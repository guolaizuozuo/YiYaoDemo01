<%--
  Created by IntelliJ IDEA.
  User: guolaizuozuo
  Date: 2019/7/26
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <style type="text/css">
        td {
            text-align: center;
        }

        .content {
            width: 800px;
            margin: 0 auto;
        }

        tr:nth-child(odd) {
            background: #FFF0CD;
        }

        #dtdata {
            margin: 0 auto;
        }

        tr:nth-child(even) {
            background: #FFF8E7;
        }
    </style>

</head>

<body>
<div class="content">
    <form action="/indexBatchDelIndexSubmit.action" method="post">
        <div class="soso">
            <input type="submit" name="txtmit" id="txtmit" value="删除"/>
        </div>
        <table border="1" id="dtdata">
            <tr>
                <td width="100" align="center"></td>
                <td width="100" align="center">姓名</td>
                <td width="100">地址</td>
                <td width="200">性别</td>
                <td width="100">操作</td>
            </tr>
            <c:forEach var="item" items="${requestScope.list}">
                <tr>
                    <td><input type="checkbox" name="studentNo" value="${item.studentNo}">
                    </td>
                    <td>${item.studentName}</td>
                    <td>${item.address}</td>
                    <td>${item.sex}</td>

                    <td>
                        <a href="javascript:void(1);" onclick="del(${item.studentName});">操作</a>
                        <a href="/studentEdit.action?studentNo=${item.studentNo}">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

</div>
</form>
</body>
</html>
