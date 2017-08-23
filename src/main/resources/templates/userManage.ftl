<#import "/common/grid.ftl" as userGrid>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Auto Height for Tabs - jQuery EasyUI Demo</title>
    
</head>
<body>
	<@userGrid.grid controller="/system/user/" title="用户" width="1100px" height="500px"
		fields="id: ,c_username:用户名,c_phone:联系方式,n_age:年龄,n_sex:性别">
		//在编辑时需要转义的字段,适用修改数据时下拉框的value和text不一致
		
	</@userGrid.grid>
	
	<script language="javascript">
		$(function(){
		    modifyElem("tb_","n_sex","combobox",'[{"id":"1","text":"男","selected":true},{"id":"0","text":"女"}]');
		    modifyElem("ed_","n_sex","combobox",'[{"id":"1","text":"男","selected":true},{"id":"0","text":"女"}]');
		    addEditElem("c_pwd","密码");
		});
		
		//在下拉框中需要转义--重写
		function needTurn(key,value){
			if(key == "c_pwd"){
				setValues(key,"");
				return true;
			}else{
				return false;
			}
		}
	</script>
</body>
</html>