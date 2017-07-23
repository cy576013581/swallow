<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Auto Height for Tabs - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="../lib/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../lib/easyui/themes/icon.css">
    <script type="text/javascript" src="../lib/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../lib/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../lib/layer/layer.js"></script>
    <script type="text/javascript">
	    function formatSex(val,row){
			if (row.n_sex){
				return "男";
			} else {
				return "女";
			}
		}
	</script>
    
</head>
<body>
	<table id="table" class="easyui-datagrid" title="用户管理" style="width:1000px;height:500px"
            data-options="rownumbers:true,singleSelect:true,url:'/system/user/findAll',method:'get',toolbar:'#tb',footer:'#ft'">
        <thead>
            <tr>
                <th data-options="field:'id',width:80,hidden:true">id</th>
                <th data-options="field:'c_username',width:200">用户名</th>
                <th data-options="field:'c_phone',width:200">联系方式</th>
                <th data-options="field:'n_age',width:200">年龄</th>
                <th data-options="field:'n_sex',width:200" formatter="formatSex">性别</th>
            </tr>
        </thead>
    </table>
    <div id="tb" style="padding:2px 5px;">
        Date From: <input class="easyui-datebox" style="width:110px">
        To: <input class="easyui-datebox" style="width:110px">
        Language: 
        <select class="easyui-combobox" panelHeight="auto" style="width:100px">
            <option value="java">Java</option>
            <option value="c">C</option>
            <option value="basic">Basic</option>
            <option value="perl">Perl</option>
            <option value="python">Python</option>
        </select>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
    </div>
    <div id="ft" style="padding:2px 5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
    </div>
</body>
</html>