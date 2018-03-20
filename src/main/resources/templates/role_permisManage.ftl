<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录记录</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/role_permis" title="角色关联权限管理" width="1100px" height="500px"
		fields="id:true: ,n_roleId:true:角色ID,c_roleName:false:角色名称,n_permisId:true:权限ID,c_permisName:false:权限名称,c_createDate:false:创建时间,c_updateDate:false:更新时间">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			modifyQueryElem("c_createDate","datebox");
		    modifyQueryElem("c_updateDate","datebox");
		    hideEditElem("c_createDate,c_updateDate,n_permisId,n_roleId");
		    hideQueryElem("n_permisId,n_roleId");
		    modifyElem("tb_","c_permisName","combobox",
		    	'['+
		    	<#list permisList as x> 
		    		'{"id":"${x.id}","text":"${x.c_permisName}"},'+
			    </#list>
			    '{"id":" ","text":"全部","selected":true}]'
		    );
		    modifyElem("ed_","c_permisName","combobox",
		    	<#list permisList as x> 
		    		<#if x_index == 0 && !x_has_next>
		    			'[{"id":"${x.id}","text":"${x.c_permisName}","selected":true}]'
		    		</#if>
		    		<#if x_index == 0 && x_has_next>
		    			'[{"id":"${x.id}","text":"${x.c_permisName}","selected":true},'+
		    		</#if>
		    		<#if x_index != 0 && x_has_next>
		    			'{"id":"${x.id}","text":"${x.c_permisName}"},'+
		    		</#if>
		    		<#if x_index != 0 && !x_has_next>
		    			'{"id":"${x.id}","text":"${x.c_permisName}"}]'
		    		</#if>
			    </#list>
			);
			
			modifyElem("tb_","c_roleName","combobox",
		    	'['+
		    	<#list roleList as x> 
		    		'{"id":"${x.id}","text":"${x.c_roleName}"},'+
			    </#list>
			    '{"id":" ","text":"全部","selected":true}]'
		    );
		    
		    modifyElem("ed_","c_roleName","combobox",
		    	<#list roleList as x> 
		    		<#if x_index == 0 && !x_has_next>
		    			'[{"id":"${x.id}","text":"${x.c_roleName}","selected":true}]'
		    		</#if>
		    		<#if x_index == 0 && x_has_next>
		    			'[{"id":"${x.id}","text":"${x.c_roleName}","selected":true},'+
		    		</#if>
		    		<#if x_index != 0 && x_has_next>
		    			'{"id":"${x.id}","text":"${x.c_roleName}"},'+
		    		</#if>
		    		<#if x_index != 0 && !x_has_next>
		    			'{"id":"${x.id}","text":"${x.c_roleName}"}]'
		    		</#if>
			    </#list>
		    );
		    
		}
		
		
	</script>
</body>
</html>