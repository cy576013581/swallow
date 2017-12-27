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
		<tr>
			<td>
				批注：<textarea id="comment" name="comment">
				</textarea>
			</td>
		</tr>
		<input type="hidden" id="taskId" name="taskId" value="${taskId}"/>
		<input type="hidden" id="id" name="id" value="${bill.id}"/>
	</table>
	<#list btnList as i>
		<button class="btn">${i}</button>
	</#list>
	<@loginRecord.grid controller="" title="批注信息" width="650px" height="150px" idDb="false"
		fields="id:true: ,assignee.id:true: ,message:false:批注内容,time:false:批注时间,user.c_username:false:批注人">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			$("#dg").datagrid({
				url: '/system/task/findComment?id='+$("#taskId").val()
			});
		    $("#btn_add").remove();
		    $("#btn_edit").remove();
		    $("#btn_remove").remove();
		    $("#tb").remove();
		    
		    $("button").on("click",function(){
		    	var outcome = $(this).html();
		    	layer.confirm('确定要审核这个请假单，提交之后不能撤销？', {
				  	btn: ['确定','取消'] //按钮
				}, function(){
				  	$.ajax({ //使用ajax与服务器异步交互
		                url:"/system/task/submit?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
		                type:"POST",
		                data: {id:$("#id").val(),taskId:$("#taskId").val(),comment:$("#comment").val(),outcome:outcome}, 
		                dataType:"json",
		                error:function(XMLHttpRequest,textStatus,errorThrown){
		                	toastr.error('网络连接失败！');
		                }, //错误提示
		
		                success:function(data){ //data为交互成功后，后台返回的数据
							var flag =data.flag;//服务器返回标记
		                    if(flag){
		                    	layer.closeAll('dialog');
		                    	var index=parent.layer.getFrameIndex(window.name);
								parent.layer.close(index);
								parent.$('#dg').datagrid('reload');
		                    	parent.toastr.success(data.msg);
		                    }else {
		                    	toastr.error(data.msg);
							}
		                }
		            });
				});
		    });
		}
		
	</script>
</body>
</html>