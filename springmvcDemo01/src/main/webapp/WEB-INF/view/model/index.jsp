<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="${pageContext.request.contextPath }/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="res/layui/css/layui.css">
    <script src="res/js/jquery-2.1.3.min.js" type="text/javascript"></script>
    <script src="res/layui/layui.js"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <style>
        .layui-table-view {
            margin: 10px 18px;
            overflow: hidden;
        }

        body {
            padding: 10px;
        }

        #sousuo td {
            padding-right: 5px;
            padding-top: 5px;
        }

        #sousuo .layui-input {
            height: 40px;
            width: 150px;
        }


    </style>
</head>
<body>
<div class="demoTable">
    &nbsp;&nbsp;&nbsp;&nbsp;
    <div class="layui-inline">
        <form class="layui-form" id="sousuo" style="float: left;">
            <table>
                <tr>
                    <td>
                        <input name="modelName1" id="modelName1" class="layui-input">

                    </td>
                </tr>
            </table>
        </form>
        <button class="layui-btn" style="margin-top: 5px;" data-type="reload">搜索</button>
        <button class="layui-btn layui-btn-normal" style="margin-top: 5px;" data-type="reload" id="add">增加上级模块</button>
    </div>
</div>


<table class="layui-table"
       lay-data="{width: 605, height:472,url:'/admin/model/findAll.action', page:true, limit: 10,id:'testReload',method:'post'}"
       lay-filter="demo">
    <thead>
    <tr>
        <th lay-data="{field:'modelName', width:200, align:'center',sort: true, fixed: true}">模块名称</th>
        <th lay-data="{field:'remark', width:200, align:'center'}">备注信息</th>
        <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
    </thead>
</table>

<script type="text/javascript">
    //同步
    $.ajaxSetup({
        async: false
    });
    $(function () {
        url = "admin/model/getErpModel.action";
        $.post(url, null, function (m) {
            for (i = 0; i < m.length; i++) {
                $("#modelName1").append("<option value='" + m[i].modelName + "'>" + m[i].modelName + "</option>");
            }
        }, "json");

        $('.demoTable .layui-btn').on('click', function () {
            var demoReload = $('#modelName1');

            table.reload('testReload', {
                where: {

                    modelName: demoReload.val()

                }
            });
        });
    })


</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">下级模块</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>


<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    var table;
    layui.use('table', function () {
        table = layui.table;
        var form = layui.form;
        //监听表格复选框选择
        table.on('checkbox(demo)', function (obj) {
            console.log(obj)
        });

        //监听工具条
        table.on('tool(demo)', function (obj) {
                var data = obj.data;
                switch (obj.event) {
                    case "detail":
                        layer.open({
                            type:2,
                            skin: 'layui-layer-molv',//样式
                            content:'admin/model/addBelow.action?modelId='+data.modelId,
                            area: ['744px', '60%'],
                            title: '编辑下级模块',

                        });
                    case "edit":
                    case "del":
                }
            }
        );


    });


</script>


<div id="div" type="dialog" times="4" showtime="0" contype="string" style="display: none;">
    <div style="height:20px;"></div>
    <form class="layui-form" action="" id="oneFrom">
        <input type="hidden" id="modelId" name="modelId">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">模块名称</label>
                <div class="layui-input-inline">
                    <input name="modelName" id="modelName" autocomplete="off" lay-verify="modelName" class="layui-input"
                           type="tel">
                </div>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注信息</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" name="remark" id="remark" class="layui-textarea"
                          style="width:400px;"></textarea>
            </div>
        </div>


        <div class="layui-layer-btn layui-layer-btn-">
            <button class="layui-btn" lay-submit lay-filter="formDemo" id="submit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
        <span class="layui-layer-resize"></span>
    </form>
</div>


</body>
</html>