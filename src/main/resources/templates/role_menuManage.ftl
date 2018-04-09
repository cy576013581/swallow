<#import "/common/checkTree.ftl" as roleAndMenu>
<#import "/common/datalist.ftl" as userlist>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>角色关联菜单</title>
    
</head>
<body>
	<@userlist.list controller="/system/role_menu/" title="用户列表"
		width="300px" height="450px">

	</@userlist.list>
	<@roleAndMenu.checkTree controller="/system/role_menu/" title="菜单列表"
		width="300px" height="450px"
		fields="name:268:菜单名称">
		
	</@roleAndMenu.checkTree>
	
	<script language="javascript">
		
			
		
	</script>
</body>
</html>