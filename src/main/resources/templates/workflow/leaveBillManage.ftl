<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/bill/" title="请假单管理" width="1300px" height="500px"
		fields="id:true: ,user.id:true: ,user.c_username:false:申请人,c_leaveReason:false:请假原因,c_leaveDays:false:请假天数,c_startTime:false:请假开始时间,c_endTime:false:请假结束时间,c_remarks:false:备注,c_createDate:false:创建时间,c_updateDate:false:更新时间">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			modifyQueryElem("c_startTime","datetimebox");
		    modifyQueryElem("c_endTime","datetimebox");
		    hideQueryElem("user.id,c_remarks,c_updateDate,c_createDate");
		    hideEditElem("user.id,user.c_username,c_updateDate,c_createDate");
		}
		
		
	</script>
</body>
</html>