<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/workflow" title="部署管理" width="1100px" height="500px"
		fields="id:true: ,name:false:部署名称,c_roleName:false:角色名称,deploymentTime:false:部署时间">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			modifyQueryElem("c_createDate","datebox");
		    modifyQueryElem("c_updateDate","datebox");
		    hideEditElem("deploymentTime");
		}
		
		
	</script>
</body>
</html>