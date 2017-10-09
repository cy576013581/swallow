<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/permission/" title="权限管理" width="1100px" height="500px"
		fields="id: ,c_permisCode:权限代码,c_permisName:权限名称">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			
		}
		
		
	</script>
</body>
</html>