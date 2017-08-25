<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Auto Height for Tabs - jQuery EasyUI Demo</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/loginRecord/" title="登录" width="1100px" height="500px"
		fields="id: ,user.c_username:登录用户,c_loginIp:登录Ip,c_createDate:登录时间">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
		    hideQueryElem("user.c_username");
		}
		
		
	</script>
</body>
</html>