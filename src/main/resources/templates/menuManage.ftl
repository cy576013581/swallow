<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/menu/" title="菜单管理" width="1100px" height="500px"
		fields="id:true: ,c_url:false:菜单地址,c_menuName:false:菜单名称,c_node:false:菜单节点,c_createDate:false:创建时间,c_updateDate:false:更新时间">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			modifyQueryElem("c_createDate","datebox");
		    modifyQueryElem("c_updateDate","datebox");
		    hideEditElem("c_createDate,c_updateDate");
		    
		    modifyElem("tb_","c_node","combobox",
		    	'['+
		    	<#list menuList as x> 
		    		'{"id":"${x.id}","text":"${x.c_menuName}"},'+
			    </#list>
			    '{"id":"","text":"全部","selected":true}]'
		    );
		    modifyElem("ed_","c_node","combobox",
		    	<#list menuList as x> 
		    		<#if x_index == 0 && !x_has_next>
		    			'[{"id":"${x.id}","text":"${x.c_menuName}","selected":true}]'
		    		</#if>
		    		<#if x_index == 0 && x_has_next>
		    			'[{"id":"${x.id}","text":"${x.c_menuName}","selected":true},'+
		    		</#if>
		    		<#if x_index != 0 >
		    			'{"id":"${x.id}","text":"${x.c_menuName}"},'+
		    		</#if>
		    			
			    </#list>
			    '{"id":"[root]","text":"[root]"}]'
			);
		}
		
		
	</script>
</body>
</html>