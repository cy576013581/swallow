<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/user_role/" title="角色管理" width="1100px" height="500px"
		fields="id:true: ,n_userId:false:用户ID,c_username:false:用户名称,n_roleId:false:角色ID,c_roleName:false:角色名称,c_createDate:false:创建时间,c_updateDate:false:更新时间">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			modifyQueryElem("c_createDate","datebox");
		    modifyQueryElem("c_updateDate","datebox");
		    hideEditElem("c_createDate");
		    hideEditElem("c_updateDate");
		    hideEditElem("n_userId");
		    hideEditElem("n_roleId");
		}
		
		
	</script>
</body>
</html>