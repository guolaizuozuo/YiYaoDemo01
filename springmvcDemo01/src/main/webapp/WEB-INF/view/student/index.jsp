<%--
  Created by IntelliJ IDEA.
  User: guolaizuozuo
  Date: 2019/7/26
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script>
        function del(dar)
        {
            var studentNo=$(dar).attr("datatype");

           if(confirm("确认删除吗")){
                $.post("/delStudentByNO/"+studentNo+"",function(result){
                  if(result>=1)
                  {
                      $(dar).parent().parent().remove();
                      alert("删除成功");
                  }
                  else {
                      alert("删除失败");}

                });
            }
        }
    </script>
</head>

<body>
<div class="content">
    <div class="soso">
        <form action="/" method="post">
            姓名：<input type="text" name="studentName" id="studentName" value="${studentName}"/>

            <input type="submit" name="txtmit" id="txtmit" value="查询" />


        </form>
    </div>
    <table border="1" id="dtdata">
        <tr>
            <td width="100" align="center">姓名</td>
            <td width="100">地址</td>
            <td width="200">性别</td>
            <td width="100">操作</td>
        </tr>
        <c:forEach var="item" items="${requestScope.list}">
            <tr>
                <td>${item.studentName}</td>
                <td>${item.address}</td>
                <td>${item.sex}</td>

                <td>
                    <a href="javascript:void(1);" datatype="${item.studentNo}" onclick="del(this);">删除</a>
                    <a href="/restfulStudentEdit/${item.studentNo}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>
