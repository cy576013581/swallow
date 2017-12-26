<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<table style="width:650px">
		<tr style="width:650px">
			<td style="width:325px">
				请假原因：<input disabled="disabled" type="text" id="c_leaveReason" name="c_leaveReason" value="${bill.c_leaveReason}"/>
			</td>
			<td style="width:325px">
				请假天数：<input disabled="disabled" type="text" id="c_leaveDays" name="c_leaveDays" value="${bill.c_leaveDays}"/>
			</td>
		</tr>
		<tr>
			<td>
				开始时间：<input disabled="disabled" type="text" id="c_startTime" name="c_startTime" value="${bill.c_startTime}"/>
			</td>
			<td>
				结束时间：<input disabled="disabled" type="text" id="c_endTime" name="c_endTime" value="${bill.c_endTime}"/>
			</td>
		</tr>
		<tr>
			<td>
				申请人：<input disabled="disabled" type="text" id="user.c_username" name="user.c_username" value="${bill.user.c_username}"/>
			</td>
			<td>
				备注信息：<input disabled="disabled" type="text" id="c_remarks" name="c_remarks" value="${bill.c_remarks}"/>
			</td>
		</tr>
		<input type="hidden" id="id" name="id" value="${taskId}"/>
	</table>
	<@loginRecord.grid controller="" title="批注信息" width="650px" height="150px" idDb="false"
		fields="id:true: ,assignee.id:true: ,message:false:批注内容,time:false:批注时间,user.c_username:false:批注人">
		
	</@loginRecord.grid>
	alert(btnList)
	<button>i</button>
	<#list btnList as i>
		alert(i)
		<button>i</button>
	</#list>
	<script language="javascript">
		//重写grid的change事件
		function change(){
			$("#dg").datagrid({
				url: '/system/task/findComment?id='+$("#id").val()
			});
		    $("#btn_add").remove();
		    $("#btn_edit").remove();
		    $("#btn_remove").remove();
		    $("#tb").remove();
		}
	</script>
</body>
</html>