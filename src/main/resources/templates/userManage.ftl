<#import "/common/grid.ftl" as userGrid>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    
</head>
<body>
	<@userGrid.grid controller="/system/user/" title="用户" width="1100px" height="500px"
		fields="id: ,c_username:用户名,c_phone:联系方式,n_age:年龄,n_sex:性别,c_createDate:创建时间,c_updateDate:更新时间">
		
	</@userGrid.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			addEditElem("c_pwd","密码");
			modifyElem("tb_","n_sex","combobox",'[{"id":"","text":"全部","selected":true},{"id":"1","text":"男"},{"id":"0","text":"女"}]');
		    modifyElem("ed_","n_sex","combobox",'[{"id":"1","text":"男","selected":true},{"id":"0","text":"女"}]');
		    modifyQueryElem("c_createDate","datebox");
		    modifyQueryElem("c_updateDate","datebox");
		    hideQueryElem("n_age");
		    hideEditElem("c_createDate");
		    hideEditElem("c_updateDate");
		    
		}
		
		
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