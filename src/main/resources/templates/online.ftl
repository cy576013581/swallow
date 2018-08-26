<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>在线用户</title>
</head>
<body>
	<#list users as u>
		<div style="background: #b7d5df; width: 150px;
		    text-align: center;height: 40px;border-radius: 3px;line-height:40px;float: left;
			margin-left: 10px;margin-bottom: 20px;">${u}</div>
	</#list>

</body>
</html>