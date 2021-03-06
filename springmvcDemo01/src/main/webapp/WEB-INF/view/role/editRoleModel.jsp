<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <base href="${pageContext.request.contextPath }/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="res/layui/css/layui.css">
    <link rel="stylesheet" href="res/zTree_v3/css/demo.css">
    <link rel="stylesheet" href="res/zTree_v3/css/zTreeStyle/zTreeStyle.css">
    <script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
    <script src="res/layui/layui.js"></script>
    <script type="text/javascript" src="res/zTree_v3/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="res/zTree_v3/js/jquery.ztree.excheck.js"></script>
<body>
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
        <li class="layui-this">查看模块</li>
        <li>编辑模块</li></ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show" class="superior-forms">
            <div class="zTreeDemoBackground left">
                <ul id="treeDemo" class="ztree"></ul>
            </div>
        </div>




        <div class="layui-tab-item">
            <div class="zTreeDemoBackground left">
                <ul id="modelDemo" class="ztree"></ul>
            </div>
            <div style="height:30px;"></div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="subordinate()">立即提交</button>
                </div>
            </div>

        </div>
    </div>
    <script>//Demo

    var id = GetQueryString("roleId");

    function subordinate(){




        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        var treeObj = $.fn.zTree.getZTreeObj("modelDemo");
        var nodes = treeObj.getCheckedNodes(true);
        var c="";
        for(var i=0;i<nodes.length;i++){
            if(nodes[i].isParent!=true){
                c+=nodes[i].id+",";
            }
        }
        var b = "";

        for(var i=0;i<nodes.length;i++){
            if(nodes[i].isParent==true){
                b+=nodes[i].id+",";
            }
        }


        layui.use('layer', function(){
            layer.confirm('确定提交吗！', function(){
                url="/admin/role/editRoleModelSubmit.action";
                data={modelId:b,roleId:id,modelSubId:c};
                $.post(url,data,function(m){
                    if(m.mes=="ok"){
                        parent.layer.close(index);
                        parent.table.reload('testReload');
                        parent.layer.msg("修改成功");
                    }
                },"json")
            });
        });
    }

    url="/admin/role/getRoleValue.action";
    data={roleId:id};
    $.post(url,data,function(m){
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            }
        };

        var zNodes = m;

        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });

    },"json");



    url="/admin/role/getModel.action";
    data={roleId:id};
    $.post(url,data,function(m){
        var setting = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };


        var zNodes = m;

        $(document).ready(function(){
            $.fn.zTree.init($("#modelDemo"), setting, zNodes);
        });

    },"json")




    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element',
        function() {
            var element = layui.element;

            //…
        });

    function GetQueryString(roleId){
        var reg = new RegExp("(^|&)"+ roleId +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }




    </script>



</body>

</html>