<%--
  Created by IntelliJ IDEA.
  User: guolaizuozuo
  Date: 2019/7/31
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div></div>

    <form action="upLoadFileSubmit" method="post"   enctype="multipart/form-data">
        <table border="0">
            <tr>
                <td colspan="2" class="tdtitle">文件上传</td>
            </tr>
            <tr>
                <td class="td" width="100">选择文件</td>
                <td width="300">
                    <input type="file" required="required" name="pic" id="exampleInputFile"></td>
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
