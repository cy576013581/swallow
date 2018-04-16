<#import "/common/checkTree.ftl" as roleAndMenu>
<#import "/common/datalist.ftl" as userlist>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>角色关联菜单</title>
    
</head>
<body>
	<div style="float: left">
		<@userlist.list controller="/system/role_menu/getUsers" title="用户列表"
		width="150px" height="400px">

		</@userlist.list>
	</div>
    <div >
		<@roleAndMenu.checkTree controller="/system/role_menu/" title="菜单列表" isSources=false
		width="300px" height="400px"
		fields="name:268:菜单名称">

		</@roleAndMenu.checkTree>
    </div>

	
	<script language="javascript">
		
			
		
	</script>
</body>
</html>