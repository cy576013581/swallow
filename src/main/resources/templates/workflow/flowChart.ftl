<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>流程图</title>
    
</head>
<body>
	<img style="position:absolute;left:0px;top:0px;" src='/system/process/lookFlowChart?deploymentId=${deploymentId}&diagramResourceName=${diagramResourceName}'>
	<!-- 2.根据当前活动的坐标，动态绘制DIV -->
	<div style="position: absolute;border:1px solid red;top:${address.y}px;left: ${address.x}px;width: ${address.width}px;height:${address.height}px;   "></div></body>
	
</body>
