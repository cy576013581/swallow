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
	
	</@userGrid.grid>
	
	<script language="javascript">
		$(function(){
		    hideQueryEle("n_sex");
		    modifyQueryEle("c_phone","numberbox");
		    modifyQueryEle("n_age","numberbox");
		});
	</script>
</body>
</html>