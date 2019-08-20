<%--
  Created by IntelliJ IDEA.
  User: guolaizuozuo
  Date: 2019/7/29
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
   <c:if test="${errors !=null}">
       <ul>
           <c:forEach items="${errors}" var="item">
               ${item.defaultMessage}
           </c:forEach>
       </ul>
   </c:if>
    <form action="studentAddSubmit.action" method="post" onsubmit="return validate();">
        <table border="0">
            <tr>
                <td colspan="2" class="tdtitle">学生数据添加</td>
            </tr>
            <tr>
                <td class="td" width="100">学生编号</td>
                <td width="300">
                    <input type="text" name="studentNo" id="studentNo"/></td>
            </tr>

            <tr>
                <td class="td" width="100">密码</td>
                <td width="300"><input type="text" name="loginPwd"  id="loginPwd"/>
                </td>
            </tr>
            <tr>
                <td class="td" width="100">学生姓名</td>
                <td width="300"><input type="text" name="studentName"  id="studentName"/>
                </td>
            </tr>
            <tr>
                <td class="td" width="100">性别</td>
                <td width="300">
                    <input type="radio" value="男" name="sex" />男
                    <input type="radio" value="女" name="sex" />女

                </td>
            </tr>
            <tr>
                <td class="td" width="100">电话</td>
                <td width="300"><input type="text" value="${student.phone}" name="phone" id="phone"/></td>
            </tr>
            <tr>
                <td class="td" width="100">地址</td>
                <td width="300"><input type="text" value="${student.address}" name="address" id="address"/></td>
            </tr>
            <tr>
                <td class="td" width="100">email</td>
                <td width="300"><input type="text" name="email" id="email"/></td>
            </tr>
            <tr>
                <td class="td" width="100">描述</td>
                <td width="300"><input type="text" name="identityCard" id="identityCard"/></td>
            </tr>


            <tr>
                <td class="td" width="100">购买时间</td>

                <td width="300"><input type="text" name="bornDate"/> yyyy-MM-DD格式
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit"
                           name="submit"  value="提交"/>
                    <input type="reset" value="重添">
                </td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>