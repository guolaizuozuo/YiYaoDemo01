<%--
  Created by IntelliJ IDEA.
  User: guolaizuozuo
  Date: 2019/7/29
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>My JSP 'add.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <style type="text/css">
        .td {
            text-align: center;
        }

        .tdtitle {
            text-align: center;
            font-size: 30px;
            font-weight: bold;

        }
    </style>
</head>

<body>

<div>
    <div></div>
    <form action="studentEditSubmit.action" method="post" onsubmit="return validate();">
        <table border="0">
            <tr>
                <td colspan="2" class="tdtitle">学生数据修改</td>
            </tr>
            <tr>
                <td class="td" width="100">学生编号</td>
                <td width="300"><input type="text" name="studentNo" id="studentNo" value="${item.studentNo}"/></td>
            </tr>
            <tr>
                <td class="td" width="100">学生姓名</td>
                <td width="300"><input type="text" name="studentName" value="${item.studentName}" id="studentName"/></td>
            </tr>
            <tr>
                <td class="td" width="100">密码</td>
                <td width="300"><input type="text" name="loginPwd" value="${item.loginPwd}" id="loginPwd"/></td>
            </tr>
            <tr>
                <td class="td" width="100">性别</td>
                <td width="300"><input type="radio" value="男" name="sex" <c:if test="${item.sex=='男'}">checked</c:if> />男
                    <input  type="radio" value="女" name="sex" <c:if test="${item.sex=='女'}">checked</c:if> />女

                </td>
            </tr>
            <tr>
                <td class="td" width="100">电话</td>
                <td width="300"><input type="text" name="phone" value="${item.phone}" id="phone"/></td>
            </tr>
            <tr>
                <td class="td" width="100">购买时间</td>

                <td width="300"><input type="text" name="bornDate" value="<fmt:formatDate value="${item.bornDate}" pattern="yyyy-MM-dd"/>"
                                       id="bornDate"/> yyyy-MM-DD格式
                </td>
            </tr>
            <tr>
                <td class="td" width="100">地址</td>
                <td width="300"><input type="text" name="address" value="${item.address}" id="address"/></td>
            </tr>
            <tr>
                <td class="td" width="100">email</td>
                <td width="300"><input type="text" name="email"  value="${item.email}" id="email"/></td>
            </tr>
            <tr>
                <td class="td" width="100">描述</td>
                <td width="300"><input type="text" name="identityCard"  value="${item.identityCard}" id="identityCard"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit"
                           name="txtname" id="txtname" value="提交"/></td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>