<#macro list controller title checkbox=true isLines=true isSources=true width="300px" height="500px" >
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
        $(function () {
            $('#dl').datalist({
                onSelect: function(index, row){
                    // alert(row.value);
                    getChoose(row.value);
                }
            });

        });
        
        function getChoose(value) {
            
        }
	</script>
</head>
<body>
	<ul id="dl" class="easyui-datalist" title="${title}" lines="${isLines}" style="width:${width};height:${height}"
        data-options="
            url: '${controller}',
            method: 'get',
            valueField: 'value',
            checkbox: ${checkbox}
            ">
		<#--<li value="AL">Alabama</li>
		<li value="AK">Alaska</li>
		<li value="AZ">Arizona</li>
		<li value="AR">Arkansas</li>-->

	</ul>
</body>
</html>
</#macro>