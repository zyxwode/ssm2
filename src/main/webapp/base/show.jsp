
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/black/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/form.validator.rules.js"></script>
    <script>
        $(function () {
            $("#dg").datagrid({
                url:'${pageContext.request.contextPath}/dept/findAll',
                toolbar: '#tb',
                pagination:true,//显示分页工具栏
                pageList:[2,4,5,6,10,20],
                columns:[[
                    {field:'id',title:'id',width:100,height:40},
                    {field:'dept_name',title:'dept_name',width:100,height:40},
                ]],
            });
        });

        //保存用户
        function opensave() {
            $("#opensave").dialog({
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    handler:function () {
                        $("#saveform").form('submit',{
                            url:'${pageContext.request.contextPath}/dept/save',
                            success:function (result) {
                                var resultObj = $.parseJSON(result);
                                if (resultObj.success) {  $.messager.show({
                                    title:'提示',
                                    /*提示信息*/
                                    msg:'保存成功！！！！！！！',
                                });}else{
                                    $.messager.show({
                                        title:'提示',
                                        /*提示信息*/
                                        msg:resultObj.message,
                                    });}
                                /*关闭dialog*/
                                $("#opensave").dialog('close');
                                /*刷新datagrid*/
                                $("#dg").datagrid('reload');
                            }
                        })
                    }
                },
                    {
                        iconCls:'icon-cancel',
                        text:'关闭',
                        handler:function () {
                            /*关闭dialog*/
                            $("#opensave").dialog('close');

                        }
                    }]
            });
        }
    </script>
</head>
<body>
<%--datagrid数据表格--%>
<table id="dg"></table>
<%--定义toolbar--%>
<div id="tb">
    <a href="#" class="easyui-linkbutton" onclick='opensave()' data-options="iconCls:'icon-add',plain:true">添加</a></div>
    <%--保存用户的对话框--%>
    <div id="opensave" data-options="href:'${pageContext.request.contextPath}/base/save.jsp',title:'保存用户信息',iconCls:'icon-man',height:300,width:500"></div>
</div>
</body>
</html>
