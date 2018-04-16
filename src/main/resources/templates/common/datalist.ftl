<#macro list controller title isLines=true isSources=true width="300px" height="500px" >
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
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

        //编辑数据
        function editData(){
            var row = $('#dl').datalist('getSelected');
            //console.log(row);
            if (row){
                console.log(row);

            }else{
                toastr.warning('在操作之前请先选中行！');
            }
        }
        $(function(){

            $('#dl').datalist({
                onLoadSuccess: function(data){
                    console.log(data);
                }
            });

        });
	</script>
</head>
<body>
	<ul id="dl" class="easyui-datalist" title="${title}" lines="${isLines}" style="width:${width};height:${height}"
        data-options="
            url: '${controller}',
            method: 'get',
            ">
		<#--<li value="AL">Alabama</li>
		<li value="AK">Alaska</li>
		<li value="AZ">Arizona</li>
		<li value="AR">Arkansas</li>-->

	</ul>
</body>
</html>
</#macro>