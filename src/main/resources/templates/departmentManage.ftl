<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/depart/" title="部门管理" width="1100px" height="500px"
		fields="id:true: ,c_departCode:false:部门代码,c_departName:false:部门名称,c_createDate:false:创建时间,c_updateDate:false:更新时间">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
		    hideQueryElem("c_updateDate,c_createDate");
		    hideEditElem("c_createDate,c_updateDate");
		}
		
		
	</script>
</body>
</html>