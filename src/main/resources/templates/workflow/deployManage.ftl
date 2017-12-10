<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<!--<h3>activiti文件部署</h3>
	<form id="deploy" method="post" action="/system/workflow/deploy" enctype="multipart/form-data">  
        <input type="text" name="name"/>  <br>
        <input type="file" name="file"/>  <br>
        <input type="submit" value="部署"/>  
    </form>  -->
	<@loginRecord.grid controller="/system/workflow/" title="部署" width="1100px" height="400px"
		fields="id:true: ,name:false:部署名称,deploymentTime:false:部署时间">
		
	</@loginRecord.grid>
	
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
		    modifyQueryElem("deploymentTime","datebox");
		    addEditElem("file","部署文件","filebox","buttonText='选择文件'");
		    hideEditElem("deploymentTime");
		}
		
		//编辑之后的确定按钮事件
		function dlgBtnClick(){
			var url;
			if(operation == 1){
				url = "/system/workflow/add?s="+new Date().getTime();
			}else if(operation == 2){
				url = "/system/workflow/update?s="+new Date().getTime();
			}
			//alert($('#form').serialize());
			$.ajax({ //使用ajax与服务器异步交互
                url:url, 
                type: "POST",
                //data: json, 
                //contentType: "multipart/form-data",
                data: $('#form').serialize(),
                dataType:"json",
                error:function(XMLHttpRequest,textStatus,errorThrown){
                	toastr.error('网络连接失败！');
                }, //错误提示

                success:function(data){ //data为交互成功后，后台返回的数据
					var flag =data.flag;//服务器返回标记
                    if(flag){
                    	$('#dlg').dialog("close");
                    	toastr.success(data.msg);
                    	$('#dlg').dialog("close");
                    	$('#dg').datagrid('reload');
                    }else {
                    	toastr.error(data.msg);
					}
                }
            });
			
		}
		
	</script>
</body>
</html>