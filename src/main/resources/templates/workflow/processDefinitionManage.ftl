<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/process/" title="部署" idDb="false" width="1100px" height="400px"
		fields="id:true: ,name:false:流程定义名称,key:false:流程定义KEY,version:false:流程定义版本,resourceName:false:规则文件名称,diagramResourceName:false:规则图片名称,deploymentId:false:部署ID">
		
	</@loginRecord.grid>
	
	
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
		    hideQueryElem("resourceName");
		    hideQueryElem("deploymentId");
		    $("#btn_add").remove();
		    $("#btn_edit").remove();
		    $("#btn_remove").remove();
		    addFtElem("btn_look","查看流程图","icon-large-smartart","lookFlowChart()");
		}
		
		function lookFlowChart(){
			var row = $('#dg').datagrid('getSelected');
            if (row){
            	layer.open({
					 type: 2,
					 title: '流程图',
					 area: ['700px', '450px'],
					 fixed: false, //不固定
					 maxmin: true,
					 content: "/system/process/lookFlowChart?deploymentId="+row.deploymentId+"&diagramResourceName="+row.diagramResourceName
				});
            }else{
				toastr.warning('在操作之前请先选中行！');
            }
			
		}
		
	</script>
</body>
</html>