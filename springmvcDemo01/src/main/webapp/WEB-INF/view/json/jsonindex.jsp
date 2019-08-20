<%--
  Created by IntelliJ IDEA.
  User: guolaizuozuo
  Date: 2019/8/2
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script>
        function requestJson1() {
            var jsonData = {
                "studentNo" :$('#studentNo').val(),
                "studentName" : $('#studentName').val()
            };
            $.ajax({
                type:"post",
                url:"/requestJson1",
                contentType:'application/json;charset=utf-8',//指定为json类型
                data:JSON.stringify(jsonData),
                success:function(data){//返回json结果
                    alert(data.bornDate);
                }
            });
        }
    </script>

</head>
<body>
学号
<input type="text" id="studentNo" name="studentNo" /><br/>
姓名
<input type="text" id="studentName" name="studentName" /><br/>
<input type="button" value="json提交" onclick="requestJson1()"/>
</body>
</html>
