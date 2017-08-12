<#macro grid controller title fields rownumbers="true" singleSelect="true" width="1000px" height="500px">
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Auto Height for Tabs - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="../lib/easyui/themes/material/easyui.css">
    <link rel="stylesheet" type="text/css" href="../lib/easyui/themes/icon.css">
    <link href="../lib/toastr/toastr.css" rel="stylesheet"/>
    <script type="text/javascript" src="../lib/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../lib/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../lib/layer/layer.js"></script>
    <script type="text/javascript" src="../lib/toastr/toastr.js"></script>
    <script type="text/javascript" src="../js/map.js"></script>
    <script language="javascript">
    	var map =new Map();
		$(function(){
		    <#list fields?split(",") as x>  
		    	<#if (x_index !=0)>
			        <#list x?split(":") as y>
			         	<#if (y_index ==0)>
							var key = "${y}";
						</#if>
						map.put(key,"textbox");
			        </#list> 
		        </#if>
		    </#list>
		});  
		
		
		function deleteData(){
			var row = $('#dg').datagrid('getSelected');
            if (row){
            	//删除行数据
				layer.confirm('确定要删除该数据吗？', {
				  	btn: ['删除','取消'] //按钮
				}, function(){
				  	$.ajax({ //使用ajax与服务器异步交互
		                url:"${controller}delete?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
		                type:"POST",
		                data: {id:row.id}, 
		                dataType:"json",
		                error:function(XMLHttpRequest,textStatus,errorThrown){
		                	toastr.error('网络连接失败！');
		                }, //错误提示
		
		                success:function(data){ //data为交互成功后，后台返回的数据
		                    var flag =data.flag;//服务器返回标记
		                    if(flag){
		                    	layer.closeAll('dialog');
		                    	toastr.success('删除成功！');
		                    	$('#dg').datagrid('reload');
		                    }else {
		                    	toastr.error('删除失败！');
							}
		                }
		            });
				});
				
            }else{
				toastr.warning('在操作之前请先选中行！');
            }
		}
		
		function addData(){
			var row = $('#dg').datagrid('getSelected');
            if (row){
            	$('#dlg').dialog("open");
            }else{
				toastr.warning('在操作之前请先选中行！');
            }
		}
		
		function editData(){
			var row = $('#dg').datagrid('getSelected');
            if (row){
            	$('#dlg').dialog("open");
            }else{
				toastr.warning('在操作之前请先选中行！');
            }
		}

		function onDblClickRow(index,field,value){
			//toastr.info('双击操作！');
			editData();
		}
		
		
		
		//根据id隐藏搜索条件
		function hideQueryEle(id){
			//$("#tb_"+id).parent().hide();
			$("#tb_"+id).parent().remove();
			map.remove(id);
		}
		
		//根据id修改输入框类型
		function modifyQueryEle(id,type){
			if(type == "datebox" || type == "combobox" || type == "combotree" || type == "numberbox" ||
			 	type == "datetimebox"){
				var parent = $("#tb_"+id).parent();
				$("#tb_"+id).textbox("destroy");
				var children = $("<input id='tb_"+id+"' type= 'text' class='easyui-"+type+"' style='width:120px'>");
				parent.append(children);
				$.parser.parse(parent);
				map.put(id,type);
			}
		}
		
		function searchData(){
			//alert($("#tb_c_phone").numberbox('getValue'));
			//alert(length);
			var json = "";
			for(var i = 0;i<map.size();i++){
				json += map.key(i)+"="+getValues(map.key(i))+"&";
			}
			json = json.substring(0,json.length-1);
			//alert(json);
			$.ajax({ //使用ajax与服务器异步交互
                url:"${controller}searchData?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
                type:"POST",
                data: json, 
                dataType:"json",
                error:function(XMLHttpRequest,textStatus,errorThrown){
                	toastr.error('网络连接失败！');
                }, //错误提示

                success:function(data){ //data为交互成功后，后台返回的数据
					$('#dg').datagrid('loadData',data);  
					toastr.success('查询成功！共查询到'+data.total+'条数据！');
                }
            });
		}
		
		
		
		function getValues(key){
			var returnVal = "";
			if(map.contains(key)>-1){
				var type = map.get(key);
				switch (type)
				{
					case "combobox":
					  returnVal = $("#tb_"+key).combobox('getValue');//$("#tb_"+key)是我自定义的格式
					  break;
					case "numberbox":
					  returnVal = $("#tb_"+key).numberbox('getValue');
					  break;
					case "datebox":
					  returnVal = $("#tb_"+key).datebox('getValue');
					  break;
					case "datetimebox":
					  returnVal = $("#tb_"+key).datetimebox('getValue');
					  break;
					case "combotree":
					  returnVal = $("#tb_"+key).combotree('getValue');
					  break;
					case "textbox":
					  returnVal = $("#tb_"+key).textbox('getValue');
					  break;
				}
			}
			return returnVal;
		}
	
	
		
	</script>
</head>
<body>
	<table id="dg" class="easyui-datagrid" title="${title}信息管理" style="width:${width};height:${height}"
            data-options="rownumbers:${rownumbers},singleSelect:${singleSelect},
            url:'${controller}findAll',method:'get',toolbar:'#tb,#ft',pagination:'true',nowrap:'true',
            onDblClickRow: onDblClickRow">
        <thead>
            <tr>
                <#list fields?split(",") as x>  
			        <#list x?split(":") as y>
			         	<#if (y_index ==0)>
			         		<#if ("${y}" == "id")>
								<th data-options="field:'${y}',width:200,hidden:true">
							<#else>	
								<th data-options="field:'${y}',width:200">
							</#if>
						<#else>
							${y}</th>
						</#if>
			        </#list> 
			    </#list>  
            </tr>
        </thead>
    </table>
    <!--查询栏-->	
    <div id="tb" style="padding:10px 10px;">
        <#list fields?split(",") as x>  
        	<#if (x_index !=0)>
		        <#list x?split(":")?reverse  as y>
		         	<#if (y_index ==0)>
		         		<#if ("${y}" != "id")>
							<span>&emsp;${y}:
						</#if>
					<#else>
						<#if ("${y}" != " ")>
							<input id="tb_${y}" name="${y}" class="easyui-textbox" style="width:120px"></span>
						</#if>
					</#if>
		        </#list> 
		    </#if>
	    </#list>
	    &emsp;<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">查询</a>
    </div>
    <!--操作栏-->
    <div id="ft" style="padding:2px 5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addData()">添加</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">编辑</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteData()">删除</a>
    </div>
    <!--编辑框-->
    <div id="dlg" class="easyui-dialog" title="编辑${title}信息" style="width:350px;height:300px;padding:10px"
            data-options="
                buttons: [{
                    text:'确定',
                    iconCls:'icon-ok',
                    handler:function(){
                        alert('ok');
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $('#dlg').dialog('close');
                    }
                }],
                minimizable:true,
                maximizable:true,
                closed:true
            ">
            <div style="margin-left:50px;margin-top:20px">
		        <#list fields?split(",") as x>  
		        	<#if (x_index !=0)>
				        <#list x?split(":")?reverse  as y>
				         	<#if (y_index ==0)>
				         		<#if ("${y}" != "id")>
									<span><span style="width:80px">${y}:</span>
								</#if>
							<#else>
								<#if ("${y}" != " ")>
									<input id="tb_${y}" name="${y}" class="easyui-textbox" style="width:120px;margin-top:10px"></span></br></br>
								</#if>
							</#if>
				        </#list> 
				    </#if>
			    </#list>
		    <div>
    </div>
</body>
</html>
</#macro>