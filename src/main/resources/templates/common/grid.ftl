<#macro grid controller title fields rownumbers="true" singleSelect="true" idDb="true" width="1000px" height="500px" ed_width="350px" ed_height="330px">
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="/lib/easyui/themes/material/easyui.css">
    <link rel="stylesheet" type="text/css" href="/lib/easyui/themes/icon.css">
    <link href="/lib/toastr/toastr.css" rel="stylesheet"/>
    <script type="text/javascript" src="/lib/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/lib/layer/layer.js"></script>
    <script language="javascript">
		var index = layer.load(1, {
		  shade: [0.5,'#D4D4D4'] //0.1透明度的白色背景
		});
	</script>
    <script type="text/javascript" src="/lib/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/lib/easyui/locale/easyui-lang-zh_CN.js"></script>
    
    <script type="text/javascript" src="/lib/toastr/toastr.js"></script>
    <script type="text/javascript" src="/js/map.js"></script>
    <script language="javascript">
    
    
    	//loading层
		
    	var map =new Map();
		var editMap =new Map();
		//操作类型,1代表添加操作,2代表编辑操作
		var operation = 1;
		$(function(){
			
		    <#list fields?split(",") as x>  
		    	<#if (x_index !=0)>
			        <#list x?split(":") as y>
			         	<#if (y_index ==0)>
							var key = "${y?replace('.','_')}";
						</#if>
						map.put(key,"textbox");
						editMap.put(key,"textbox");
			        </#list> 
		        </#if>
		    </#list>
		    change();
		    $('#dg').datagrid({
				onLoadSuccess: function(){
					$("#box").show();
					layer.close(index);
				}
			});
		    
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
		                    	toastr.success(data.msg);
		                    	$('#dg').datagrid('reload');
		                    }else {
		                    	toastr.error(data.msg);
		                    	layer.closeAll('dialog');
							}
		                }
		            });
				});
				
            }else{
				toastr.warning('在操作之前请先选中行！');
            }
		}
		
		function searchData(){
			var options = $('#dg').datagrid('getPager').data("pagination").options;  
			var json = "";
			for(var i = 0;i<map.size();i++){
				json += map.key(i)+"="+getValues(map,"tb_",map.key(i))+"&";
				//var arr = $("#tb_"+map.key(i)).attr("class");
				//alert(map.key(i)+"="+getValues(map,"tb_",map.key(i)));
			}
			json += "rows="+options.pageSize
			//alert(json);
			$.ajax({ //使用ajax与服务器异步交互
                url:"${controller}searchData?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
                type:"POST",
                data: json, 
                async: false,
                dataType:"json",
                error:function(XMLHttpRequest,textStatus,errorThrown){
                	toastr.error('网络连接失败！');
                }, //错误提示

                success:function(data){ //data为交互成功后，后台返回的数据
                	//$('#dg').datagrid('gotoPage', 1);
					$('#dg').datagrid('loadData',data);  
					toastr.success('查询成功！共查询到'+data.total+'条数据！');
                }
            });
		}
		
		
		//添加数据
		function addData(){
            operation = 1;
            //清空编辑框的值
            for(var i = 0;i<editMap.size();i++){
            	//alert(editMap.key(i));
				setValues(editMap.key(i),'');
			}
            $('#dlg').dialog("open");
		}
		
		//编辑数据
		function editData(){
			var row = $('#dg').datagrid('getSelected');
			//console.log(row);
            if (row){
            	operation = 2;
            	
            	var jsonStr = JSON.stringify(row);
            	var reg = new RegExp('"','g');
            	jsonStr = jsonStr.substring(1,jsonStr.length-1).replace(reg,'');
            	var attr = jsonStr.split(",");
            	//console.log(attr);
            	for(var i=0;i<attr.length;i++){
            		var attr2 =  attr[i].split(":")
            		if(attr2[1] != "null" && attr2[1] != ""){
            			if(attr2.lenth==2){
	            			for(var j=0;j<attr2.length-1;j++){
		            			if(attr2[0] == "id"){
		            				$("#ed_id").val(attr2[1]);
		            				continue;
		            			}
		            			//alert(attr2[0]+":"+attr2[1]);
		            			if(!needTurn(attr2[0],attr2[1])){
		            				setValues(attr2[0],attr2[1]);
		            			}
		            			
		            		}
	            		}else{
	            			for(var j=0;j<attr2.length-1;j++){
		            			if(attr2[0] == "id"){
		            				$("#ed_id").val(attr2[1]);
		            				continue;
		            			}
		            			for(var x=2;x<attr2.length;x++){
		            				attr2[1] += ":"+attr2[x];
		            			}
		            			//alert(attr2[0]+":"+attr2[1]);
		            			if(!needTurn(attr2[0],attr2[1])){
		            				setValues(attr2[0],attr2[1]);
		            			}
		            			
		            		}
	            		}
            		}
            		
            	}
            	$('#dlg').dialog("open");
            	
            }else{
				toastr.warning('在操作之前请先选中行！');
            }
		}
		
		//编辑之后的确定按钮事件
		//用表单不支持把时间类型的数据筛选进来
		function dlgBtnClick(){
			var url;
			var json = "";
			for(var i = 0;i<editMap.size();i++){
				json += editMap.key(i)+"="+getValues(editMap,"ed_",editMap.key(i))+"&";
			}
			if(operation == 1){
				url = "${controller}add";
				json = json.substring(0,json.length-1);
			}else if(operation == 2){
				url = "${controller}update";
				json += "id="+$("#ed_id").val();
			}
			//alert($('#form').serialize());
			$.ajax({ //使用ajax与服务器异步交互
                url:url+"?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
                type: "POST",
                data: json, 
                //contentType: "multipart/form-data",
                //data: $('#form').serialize(),
                dataType:"json",
                error:function(XMLHttpRequest,textStatus,errorThrown){
                	toastr.error('网络连接失败！');
                }, //错误提示

                success:function(data){ //data为交互成功后，后台返回的数据
					var flag =data.flag;//服务器返回标记
                    if(flag){
                    	$('#dlg').dialog("close");
                    	toastr.success(data.msg);
                    	$('#dlg').dialog("close");
                    	$('#dg').datagrid('reload');
                    }else {
                    	toastr.error(data.msg);
					}
                }
            });
			
		}

		//实现双击编辑操作
		function onDblClickRow(index,field,value){
			//toastr.info('双击操作！');
			if("${idDb}" == "true"){
				editData();
			}
			
		}
		
		//根据id隐藏查询框搜索条件
		function hideQueryElem(ids){
			var arr = ids.split(',');
			//console.log(arr);
			for(var index = 0;index < arr.length;index++){
				var id = arr[index].replace(".", "_");
				$("#tb_"+id).parent().remove();
				map.remove(id);
			}
		}
		
		//根据id修改查询框输入框类型
		function modifyQueryElem(id,type){
			id = id.replace(".", "_");
			if(type == "datebox" || type == "numberbox" || type == "datetimebox"){
				var parent = $("#tb_"+id).parent();
				$("#tb_"+id).textbox("destroy");
				var children = $("<input id='tb_"+id+"' type= 'text' class='easyui-"+type+"' style='width:120px'>");
				parent.append(children);
				$.parser.parse(parent);
				map.put(id,type);
			}
		}
		
		//根据id修改输入框类型
		/*
		loc:控件位置，值为tb_和ed_，分别代表工具栏和查询栏
		示例：modifyElem("tb_","n_status","combobox",'[{"id":"","text":"全部","selected":true},{"id":"1","text":"可用"},{"id":"0","text":"锁定"}]');
		*/
		function modifyElem(loc,id,type,data){
			id = id.replace(".", "_");
			if(type == "combobox" || type == "combotree"){
				var parent = $("#"+loc+id).parent();
				$("#"+loc+id).textbox("destroy");
				var children = $("<input id='"+loc+id+"' name='"+id+"' type= 'text' class='easyui-"+type+"' style='width:120px' valueField='id' textField='text' panelHeight='auto'>");
				parent.append(children);
				$.parser.parse(parent);
				if(loc == "ed_"){
					editMap.put(id,type);
				}else if(loc == "tb_"){
					map.put(id,type);
				}
				data = JSON.parse(data);
				if(type == "combobox"){
					//console.log(data);
					$("#"+loc+id).combobox("loadData",data);
				}else if(type == "combotree"){
					$("#"+loc+id).combotree("loadData",data);
				}
			}
		}
		
		//根据id隐藏编辑框搜索条件
		function hideEditElem(ids){
			var arr = ids.split(',');
			//console.log(arr);
			for(var index = 0;index < arr.length;index++){
				var id = arr[index].replace(".", "_");
				$("#ed_"+id).parent().remove();
				editMap.remove(id);
			}
		}
		
		function change(){
		}
		
		//extend : 扩展字段
		//type : 控件类型
		//name : 控件名称
		//id : 控件key
		function addEditElem(id,name,type,extend){
			id = id.replace(".", "_");
			var parent = $("#form");
			var childen = $("<span>"+name+": <input id='ed_"+id+"' name='"+id+"' class='easyui-"+type+"' style='width:120px;margin-top:10px'" + extend + "></span></br></br>");
			parent.append(childen);
			$.parser.parse(childen);
			editMap.put(id,"textbox");
		}
		
		// 添加操作栏按钮
		function addFtElem(id,name,iconClsName,functionName){
			id = id.replace(".", "_");
			var parent = $("#ft");
			var childen = $("<a id='"+id+"' href='#' class='easyui-linkbutton' plain='true' onclick='"+functionName+"'>"+name+"</a>");
			childen.linkbutton({    
			    iconCls: iconClsName,
			    plain:  true
			});  
			parent.append(childen);
		}
		
		//根据id修改编辑框输入框类型
		function modifyEditElem(id,type){
			id = id.replace(".", "_");
			if(type == "datebox" || type == "combobox" || type == "combotree" || type == "numberbox" ||
			 	type == "datetimebox"){
				var parent = $("#ed_"+id).parent();
				$("#ed_"+id).textbox("destroy");
				var children = $("<input id='ed_"+id+"' type= 'text' class='easyui-"+type+"' style='width:120px'>");
				parent.append(children);
				$.parser.parse(parent);
				editMap.put(id,type);
			}
		}
		
		//根据id设置编辑框是否为只读
		function modifyEditEle(id,type){
			
		}
		
		//在下拉框中需要转义
		//提供重写方法
		function needTurn(){
			
		}
		
		function setValues(key,value){
			
			if(editMap.contains(key)>-1){
				var type = editMap.get(key);
				//alert("key:"+key+"type:"+type);
				switch (type)
				{
					case "combobox":
						var attr = $("#ed_"+key).combobox('getData');
						for(var i =0;i<attr.length;i++){
							if(attr[i].text==value){
								$("#ed_"+key).combobox('select',attr[i].id);
							}
						}
					    break;
					case "numberbox":
					  $("#ed_"+key).numberbox('setValue',value);
					  break;
					case "datebox":
					  $("#ed_"+key).datebox('setValue',value);
					  break;
					case "datetimebox":
					  $("#ed_"+key).datetimebox('setValue',value);
					  break;
					case "combotree":
					  var attr = $("#ed_"+key).combotree('getData');
						for(var i =0;i<attr.length;i++){
							if(attr[i].text==value){
								$("#ed_"+key).combotree('select',attr[i].id);
							}
						}
					  break;
					case "textbox":
					  $("#ed_"+key).textbox('setValue',value);
					  break;
				}
			}
		}
		
		function getValues(map,loc,key){
			var returnVal = "";
			if(map.contains(key)>-1){
				var type = map.get(key);
				switch (type)
				{
					case "combobox":
					  	returnVal = $("#"+loc+key).combobox('getValue');//$("#tb_"+key)是我自定义的格式
					  	break;
					case "numberbox":
					  	returnVal = $("#"+loc+key).numberbox('getValue');
					  	break;
					case "datebox":
					  	returnVal = $("#"+loc+key).datebox('getValue');
					  	break;
					case "datetimebox":
					  	returnVal = $("#"+loc+key).datetimebox('getValue');
					  	break;
					case "combotree":
					  	returnVal = $("#"+loc+key).combotree('getValue');
					  	break;
					case "textbox":
					  	returnVal = $("#"+loc+key).textbox('getValue');
					  	//alert("#"+loc+key+":"+returnVal);
					  	break;
					case "filebox":
					  	returnVal = $("#"+loc+key).textbox('getValue');
					  	//alert("#"+loc+key+":"+returnVal);
					  	break;
				}
			}
			return returnVal;
		}
	
	
		
	</script>
</head>
<body>
	<div id="box" style="display:none;">
		<table id="dg" class="easyui-datagrid" title="${title}" style="width:${width};height:${height}"
            data-options="rownumbers:${rownumbers},singleSelect:${singleSelect},
            url:'${controller}findAll',method:'get',toolbar:'#tb,#ft',pagination:'true',nowrap:'true',
            onDblClickRow: onDblClickRow">
        <thead>
            <tr>
                <#list fields?split(",") as x>  
			        <#list x?split(":") as y>
			         	<#if (y_index ==0)>
			         		<th data-options="field:'${y}',width:150,
						
						</#if>
						<#if (y_index ==1)>
							hidden: ${y}">
						</#if>
						<#if (y_index ==2)>
							${y}</th>
						</#if>
			        </#list> 
			    </#list>  
            </tr>
        </thead>
    </table>
    <!--查询栏-->	
    <div id="tb" style="padding:20px 10px;">
        <#list fields?split(",") as x>  
        	<#if (x_index !=0)>
		        <#list x?split(":")?reverse  as y>
		         	<#if (y_index ==0 && "${y}" != "id")>
						<span>${y}:
					
					</#if>
					<#if (y_index ==2 && "${y}" != " ")>
						<input id="tb_${y?replace('.','_')}" name="${y}" class="easyui-textbox" style="width:120px"></span>&emsp;
					</#if>
		        </#list> 
		    </#if>
	    </#list>
	    &emsp;<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">查询</a>
    </div>
    <!--操作栏-->
    <div id="ft" style="padding:2px 5px;">
        <a id="btn_add" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addData()">添加</a>
        <a id="btn_edit" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">编辑</a>
        <a id="btn_remove" href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteData()">删除</a>
    </div>
    <!--编辑框-->
    <div id="dlg" class="easyui-dialog" title="编辑${title}信息" style="width:${ed_width};height:${ed_height};padding:10px"
            data-options="
                buttons: [{
                    text:'确定',
                    iconCls:'icon-ok',
                    handler:function(){
                       dlgBtnClick();
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
            <div id="dlg_box" style="margin-left:50px;margin-top:20px">
            	<form id="form" method="post" enctype="multipart/form-data">  
	            	<input type="text" id="ed_id" name="id" style="display:none" value="0">
			        <#list fields?split(",") as x>  
			        	<#if (x_index !=0)>
					        <#list x?split(":")?reverse  as y>
								<#if (y_index ==0 && "${y}" != "id")>
									<div style='margin-bottom:20px'>${y}:
								</#if>
								<#if (y_index ==2 && "${y}" != " ")>
									<input id="ed_${y?replace('.','_')}" name="${y}" class="easyui-textbox" style="width:120px;margin-top:10px"></div>
								</#if>
					        </#list> 
					    </#if>
				    </#list>
			    </form>  
		    <div>
    </div>
	</div>
</body>
</html>
</#macro>