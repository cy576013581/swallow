<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<h3>activiti文件部署</h3>
	<form id="deploy" method="post" action="/system/workflow/deploy" enctype="multipart/form-data">  
        <input type="text" name="name"/>  <br>
        <input type="file" name="file"/>  <br>
        <input type="submit" value="部署"/>  
    </form>  
    <br>
	<@loginRecord.grid controller="/system/workflow/" title="部署" width="1100px" height="400px"
		fields="id:true: ,name:false:部署名称,deploymentTime:false:部署时间">
		
	</@loginRecord.grid>
	
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			modifyQueryElem("c_createDate","datebox");
		    modifyQueryElem("c_updateDate","datebox");
		    hideEditElem("deploymentTime");
		}
		
		
	</script>
</body>
</html>