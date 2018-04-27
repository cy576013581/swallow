<#macro checkTree controller title treeField fields isSources=true rownumbers=true checkbox=true width="1000px" height="500px">
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>多选框</title>

    <#if (isSources)>
        <link rel="stylesheet" type="text/css" href="/lib/easyui/themes/material/easyui.css">
        <link rel="stylesheet" type="text/css" href="/lib/easyui/themes/icon.css">
        <link href="/lib/toastr/toastr.css" rel="stylesheet"/>
        <script type="text/javascript" src="/lib/easyui/jquery.min.js"></script>
        <script type="text/javascript" src="/lib/layer/layer.js"></script>
        <script type="text/javascript" src="/lib/easyui/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="/lib/easyui/locale/easyui-lang-zh_CN.js"></script>
        <script type="text/javascript" src="/lib/toastr/toastr.js"></script>
    </#if>
    <script language="javascript">

        $(function(){
            $('#ct').treegrid({
                onSelect: function(row){
                    //加载完毕后获取所有的checkbox遍历
                    // console.log(row);
                    // var level = $('#ct').treegrid("getLevel",row.id);
                }
            });
        })
   
		
	</script>
</head>
<body>
    <table id="ct" title="${title}" class="easyui-treegrid" style="width:${width};height:${height};"
            data-options="
                url: '${controller}',
                method: 'get',

                <#--checkbox: ${checkbox},  //由于尝试多次，无法再复选框中动态勾选，故先取消勾选框-->
                rownumbers: ${rownumbers},
                idField: 'id',
                <#--checkOnSelect : true,-->
                <#--selectOnCheck : true,-->
                singleSelect : false,  //是否单选
                striped: true,
                treeField : '${treeField}'">
        <thead>
            <tr>
                <!--<th data-options="field:'name'" width="220">Name</th>
                <th data-options="field:'size'" width="100" align="right">Size</th>
                <th data-options="field:'date'" width="150">Modified Date</th>-->

                <#list fields?split(",") as x>
			        <#list x?split(":") as y>
			         	<#if (y_index ==0)>
			         		<th data-options="field:'${y}',

						</#if>
						<#if (y_index ==1)>
							width: ${y}">
						</#if>
						<#if (y_index ==2)>
							${y}</th>
						</#if>
			        </#list>
			    </#list>
            </tr>
        </thead>
    </table>
</body>
</html>
</#macro>