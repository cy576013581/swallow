<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>请假单管理</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/bill/" title="请假单管理" width="1400px" height="500px"
		fields="id:true: ,user.id:true: ,user.c_username:false:申请人,n_status:false:审核状态,c_leaveReason:false:请假原因,c_leaveDays:false:请假天数,c_startTime:false:请假开始时间,c_endTime:false:请假结束时间,c_remarks:false:备注,c_createDate:false:创建时间,c_updateDate:false:更新时间">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			modifyQueryElem("c_startTime","datebox");
		    modifyQueryElem("c_endTime","datebox");
		    modifyQueryElem("c_leaveDays","numberbox");
		    hideQueryElem("user.id,c_remarks,c_updateDate,c_createDate,n_status");
		    hideEditElem("user.id,user.c_username,c_updateDate,c_createDate,n_status");
		    modifyEditElem("c_startTime","datebox");
		    modifyEditElem("c_endTime","datebox");
		    //添加解锁按钮
		    var button = $("<a id='btn_submit' href='#' class='easyui-linkbutton' onclick='submitBill()'>审核</a>");
			button.linkbutton({    
			    iconCls: 'icon-ok',
			    plain:  true
			});  
			var ft = $("#ft");
			ft.append(button);
			$('#dg').datagrid({
				onClickRow: function(index, row){
					if("未提交" == row.n_status){
	            		$('#btn_edit').linkbutton('enable');
						$('#btn_remove').linkbutton('enable');
						$('#btn_submit').linkbutton('enable');
					}else if("审核中" == row.n_status){
						$('#btn_edit').linkbutton('disable');
						$('#btn_remove').linkbutton('disable');
						$('#btn_submit').linkbutton('disable');
					}else if("审核通过" == row.n_status){
						$('#btn_edit').linkbutton('disable');
						$('#btn_remove').linkbutton('disable');
						$('#btn_submit').linkbutton('disable');
					}
				}
			});
			
		}
		
		function submitBill(){
			var row = $('#dg').datagrid('getSelected');
            if (row){
            	var msg ="";
            	var n_status;
            	//0：未提交   1：审核中    2：审核通过
            	/*if("未提交" == row.n_status){
						n_status = 1;
				}else if("审核中" == row.n_status){
					n_status = 2;
				}*/
				layer.confirm('确定要提交这个请假单，提交之后不能撤销？', {
				  	btn: ['确定','取消'] //按钮
				}, function(){
					//alert(row.n_status);
				  	$.ajax({ //使用ajax与服务器异步交互
		                url:"/system/bill/submit?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
		                type:"POST",
		                data: {id:row.id,n_status:row.n_status}, 
		                dataType:"json",
		                error:function(XMLHttpRequest,textStatus,errorThrown){
		                	toastr.error('网络连接失败！');
		                }, //错误提示
		
		                success:function(data){ //data为交互成功后，后台返回的数据
							var flag =data.flag;//服务器返回标记
		                    if(flag){
		                    	layer.closeAll('dialog');
		                    	toastr.success(msg+data.msg);
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
		
	</script>
</body>
</html>