<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>信息管理系统界面</title>
	<link rel="stylesheet" type="text/css" href="../lib/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../lib/easyui/themes/icon.css">
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../lib/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		
		function addTab(title,url){
			var content = '<iframe src="'+url+'" id="iframe" width="100%" height="99%" frameborder="0"></iframe>';
			$('#mainTabs').tabs('add',{
			    title:title,
			    content:content,
			    closable:true
			});
		}
		
	</script>
</head>
<body>
	<!-- 顶部栏-->
	<div id="top" style="background:url(../images/topbg.gif) repeat-x;width:100%;height:auto;overflow:hidden;">
		<#include "/main/top.ftl">
	</div>
	<!-- 侧边栏-->
	<div width="100%" >
		<#include "/main/left.ftl">
		<!-- 右部主界面栏-->
		<div id="main">
			<div class="easyui-tabs" id="mainTabs" data-options="border:false" 
				style="width:100%;height:100%;">
			<div title="主页" data-options="closable:false" >
				<iframe src="/menu/home" id="iframe" width="100%" height="99%" frameborder="0"></iframe>
			</div>
		</div>
		</div>
	
	</div>
</body>
</html>
