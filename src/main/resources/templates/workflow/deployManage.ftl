<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<h3>activiti文件部署</h3>
	<form id="deploy" method="post" action="/system/deploy/add" enctype="multipart/form-data">  
        <input class="easyui-textbox" name="name" style="width:200px" data-options="prompt:'文件名称'"> <br>
        <input class="easyui-filebox" style="width:200px" name="file" buttonText='选择文件' prompt='选择要部署的文件'>
        <input type="submit" value="部署"/>  
    </form>
	<@loginRecord.grid controller="/system/deploy" title="部署" width="1100px" height="400px"
		fields="id:true: ,name:false:部署名称,deploymentTime:false:部署时间">
		
	</@loginRecord.grid>
	
	
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
		    modifyQueryElem("deploymentTime","datebox");
		    //addEditElem("file","部署文件","filebox","buttonText='选择文件'");
		    hideQueryElem("deploymentTime");
		    $("#btn_edit").remove();
		}
		
	</script>
</body>
</html>