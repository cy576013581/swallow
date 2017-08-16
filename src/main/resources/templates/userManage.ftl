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
		if(attr2[0] == "n_sex"){
			if(attr2[1] == "男"){
				attr2[1]=1;
			}else{
				attr2[1]=0;
			}
			setValues(attr2[0],attr2[1]);
			continue;
		}
	</@userGrid.grid>
	
	<script language="javascript">
		$(function(){
		    //hideQueryElem("n_sex");
		    //modifyQueryElem("c_phone","numberbox");
		    //modifyQueryElem("n_age","numberbox");
		    modifyElem("tb_","n_sex","combobox",'[{"id":"1","text":"男","selected":true},{"id":"0","text":"女"}]');
		    modifyElem("ed_","n_sex","combobox",'[{"id":"1","text":"男","selected":true},{"id":"0","text":"女"}]');
		    //hideEditElem("n_sex");
		    //modifyEditElem("n_age","datebox");
		    addEditElem("c_pwd","密码");
		});
	</script>
</body>
</html>