<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	
	<@loginRecord.grid controller="/system/loginRecord/" idDb="false" title="登录" width="1100px" height="500px"
		fields="id:true: ,c_username:false:登录用户,c_loginIp:false:登录IP,c_createDate:false:登录时间">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			modifyQueryElem("c_createDate","datebox");
			$('#btn_add').linkbutton('disable');
			$('#btn_edit').linkbutton('disable');
			$('#btn_remove').linkbutton('disable');
		}
		
		
	</script>
</body>
</html>