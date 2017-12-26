<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/task/" title="个人任务" width="1100px" height="400px" idDb="false"
		fields="id:true: ,assignee.id:true: ,name:false:任务名称,createTime:false:创建时间,assignee.c_username:false:办理人">
		
	</@loginRecord.grid>
	
	
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
		    modifyQueryElem("createTime","datebox");
		    $("#btn_add").remove();
		    $("#btn_edit").remove();
		    $("#btn_remove").remove();
		    
		    addFtElem("btn_submit","审核","icon-ok","submitTask()");
		    addFtElem("btn_look","查看当前流程图","icon-large-smartart","lookFlowChart()");
		    
		    hideQueryElem("assignee.id,createTime,assignee.c_username")
		}
		
		function submitTask(){
			var row = $('#dg').datagrid('getSelected');
            if (row){
				layer.confirm('确定要审核这个请假单，提交之后不能撤销？', {
				  	btn: ['确定','取消'] //按钮
				}, function(){
				  	$.ajax({ //使用ajax与服务器异步交互
		                url:"/system/task/submit?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
		                type:"POST",
		                data: {id:row.id}, 
		                dataType:"json",
		                error:function(XMLHttpRequest,textStatus,errorThrown){
		                	toastr.error('网络连接失败！');
		                }, //错误提示
		
		                success:function(data){ //data为交互成功后，后台返回的数据
							var flag =data.flag;//服务器返回标记
		                    if(flag){
		                    	layer.closeAll('dialog');
		                    	toastr.success(data.msg);
		                    	$('#dg').datagrid('reload');
		                    }else {
		                    	toastr.error(data.msg);
							}
		                }
		            });
				});
				
            }else{
				toastr.warning('在操作之前请先选中行！');
            }
		}
		
		function lookFlowChart(){
			var row = $('#dg').datagrid('getSelected');
            if (row){
            	layer.open({
					 type: 2,
					 area: ['700px', '450px'],
					 fixed: false, //不固定
					 maxmin: true,
					 content: "/system/process/lookFlowChart?id="+row.id
				});
            }else{
				toastr.warning('在操作之前请先选中行！');
            }
		}
	</script>
</body>
</html>