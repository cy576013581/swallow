<#import "/common/grid.ftl" as userGrid>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    
</head>
<body>
	<@userGrid.grid controller="/system/user" title="用户" width="1400px" height="500px"
		fields="id:true: ,n_departmentId.id:true: ,c_username:false:用户名,n_departmentId.c_departName:false:所属部门,c_phone:false:联系方式,c_email:false:电子邮箱,n_age:false:年龄,n_sex:false:性别,n_status:false:用户状态,c_createDate:false:创建时间,c_updateDate:false:更新时间">
		
	</@userGrid.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			addEditElem("c_pwd","密码","textbox","");
			modifyElem("tb_","n_sex","combobox",'[{"id":"","text":"全部","selected":true},{"id":"1","text":"男"},{"id":"0","text":"女"}]');
		    modifyElem("ed_","n_sex","combobox",'[{"id":"1","text":"男","selected":true},{"id":"0","text":"女"}]');
		    modifyElem("tb_","n_status","combobox",'[{"id":"","text":"全部","selected":true},{"id":"1","text":"可用"},{"id":"0","text":"锁定"}]');
		    
		    modifyQueryElem("c_createDate","datebox");
		    modifyQueryElem("c_updateDate","datebox");
		    hideQueryElem("n_age,n_departmentId.id");
		    hideEditElem("c_createDate,c_updateDate,n_status,n_departmentId.id");
		    
		    //添加解锁按钮
			addFtElem("btn_lock","锁定/解锁","icon-lock","lockUser()");
			
			//departList
			modifyElem("tb_","n_departmentId.c_departName","combobox",
		    	'['+
		    	<#list departList as x> 
		    		'{"id":"${x.id}","text":"${x.c_departName}"},'+
			    </#list>
			    '{"id":" ","text":"全部","selected":true}]'
		    );
		    modifyElem("ed_","n_departmentId.c_departName","combobox",
			    '['+
		    	<#list departList as x> 
		    		<#if !x_has_next>
		    			'{"id":"${x.id}","text":"${x.c_departName}"}'
		    		</#if>

		    		<#if x_has_next>
		    			'{"id":"${x.id}","text":"${x.c_departName}"},'+
		    		</#if>
			    </#list>
			    + ']'
		    );
		}
		
		//在下拉框中需要转义--重写
		//转义json中带对象的
		//转义密码
		function needTurn(key,value){
			if(key == "c_pwd"){
				setValues(key,"");
				return true;
			}if(key == "c_departName"){
				setValues("n_departmentId_c_departName",value);
				return true;
			}else{
				return false;
			}
		}
		
		function lockUser(){
			var row = $('#dg').datagrid('getSelected');
            if (row){
            	var msg ="";
            	var n_status;
            	if("可用" == row.n_status){
						msg = "锁定";
						n_status = 0;
					}else if("锁定" == row.n_status){
						msg = "解锁";
						n_status = 1;
					}
				layer.confirm('确定要对该用户进行'+msg+'操作？', {
				  	btn: ['确定','取消'] //按钮
				}, function(){
					//alert(row.n_status);
				  	$.ajax({ //使用ajax与服务器异步交互
		                url:"/system/user/lock?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
		                type:"POST",
		                data: {id:row.id,n_status:n_status}, 
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