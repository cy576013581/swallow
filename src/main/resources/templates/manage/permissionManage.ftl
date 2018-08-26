<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/permission" title="权限管理" width="1100px" height="500px"
		fields="id:true: ,c_permisCode:false:权限代码,c_permisName:false:权限名称,c_createDate:false:创建时间,c_updateDate:false:更新时间">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			modifyQueryElem("c_createDate","datebox");
		    modifyQueryElem("c_updateDate","datebox");
		    hideEditElem("c_createDate,c_updateDate");
		}
		
		
	</script>
</body>
</html>