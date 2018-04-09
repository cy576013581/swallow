<#macro list controller title isLines=true width="300px" height="500px" >
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="/lib/easyui/themes/material/easyui.css">
    <link rel="stylesheet" type="text/css" href="/lib/easyui/themes/icon.css">
    <link href="/lib/toastr/toastr.css" rel="stylesheet"/>
    <script type="text/javascript" src="/lib/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/lib/layer/layer.js"></script>
    <script type="text/javascript" src="/lib/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/lib/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/lib/toastr/toastr.js"></script>
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
	</script>
</head>
<body>
	<ul id="dl" class="easyui-datalist" title="${title}" lines="${isLines}" style="width:400px;height:250px"
        data-options="
            url: '${controller}',
            method: 'get',
            ">
		<li value="AL">Alabama</li>
		<li value="AK">Alaska</li>
		<li value="AZ">Arizona</li>
		<li value="AR">Arkansas</li>
		<li value="CA">California</li>
		<li value="CO">Colorado</li>
		<li value="CT">Connecticut</li>
		<li value="DE">Delaware</li>
		<li value="FL">Florida</li>
		<li value="GA">Georgia</li>
		<li value="HI">Hawaii</li>
		<li value="ID">Idaho</li>
		<li value="IL">Illinois</li>
		<li value="IN">Indiana</li>
		<li value="IA">Iowa</li>
		<li value="KS">Kansas</li>
		<li value="KY">Kentucky</li>
		<li value="LA">Louisiana</li>
		<li value="ME">Maine</li>
		<li value="MD">Maryland</li>
		<li value="MA">Massachusetts</li>
		<li value="MI">Michigan</li>
		<li value="MN">Minnesota</li>
		<li value="MS">Mississippi</li>
		<li value="MO">Missouri</li>
		<li value="MT">Montana</li>
		<li value="NE">Nebraska</li>
		<li value="NV">Nevada</li>
		<li value="NH">New Hampshire</li>
		<li value="NJ">New Jersey</li>
		<li value="NM">New Mexico</li>
		<li value="NY">New York</li>
		<li value="NC">North Carolina</li>
		<li value="ND">North Dakota</li>
		<li value="OH">Ohio</li>
		<li value="OK">Oklahoma</li>
		<li value="OR">Oregon</li>
		<li value="PA">Pennsylvania</li>
	</ul>
</body>
</html>
</#macro>