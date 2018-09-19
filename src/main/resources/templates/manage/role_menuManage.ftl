<#import "/common/checkTree.ftl" as roleAndMenu>
<#import "/common/datalist.ftl" as userlist>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>角色关联菜单</title>
    <link rel="stylesheet" href="/lib/layui/css/layui.css">
</head>
<body>
	<div style="float: left">
		<@userlist.list controller="/system/role_menu/getRoles" title="角色列表"
		width="150px" height="400px">

		</@userlist.list>
	</div>
    <div >
		<@roleAndMenu.checkTree controller="/system/role_menu/getMenus" title="菜单列表" isSources=false
		width="550px" height="400px" treeField="c_menuName"
		fields="c_menuName:150:菜单名称,c_url:340:请求地址">

		</@roleAndMenu.checkTree>
    </div>
    <div style="width: 700px;text-align: center">
        <button onclick="update()" class="layui-btn layui-btn-normal" style="margin: 10px">确认修改</button>
    </div>

	
	<script language="javascript">

		function getChoose(value) {
            $.ajax({ //使用ajax与服务器异步交互
                url:"/system/role_menu/"+value+"?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
                type:"GET",
                //data: {id:row.id},
                dataType:"json",
                error:function(XMLHttpRequest,textStatus,errorThrown){
                    toastr.error('网络连接失败！');
                }, //错误提示

                success:function(data){ //data为交互成功后，后台返回的数据
					if (data.flag){
					    if(null==data.rows){
                            $("#ct").treegrid("clearChecked");
						}else{
                            $("#ct").treegrid("clearChecked");
                            for (var i = 0;i<data.rows.length;i++){
                                // if("[root]" === data.rows[i].c_node.toString()){
                                 //    break;
								// }
                                // alert(data.rows[i].n_menuId);
                                $("#ct").treegrid("select",data.rows[i].n_menuId);
                            }
						}

					}

                    // $("ct").treegrid("loadData",data);
                }
            });
        }
        
        function update() {
            var role = $('#dl').datalist("getSelected");
            if(null == role){
                toastr.warning("请选择操作角色！");
                return;
            }
            var roleId = role.value;
            var menu = $('#ct').treegrid("getSelections");
            var len = menu.length;
            var menuIds = "";
            $.each(menu,function(index,value){
                if (index < len-1){
                    menuIds = menuIds+value.id+",";
                }else if (index = len-1){
                    menuIds = menuIds+value.id;
                }
            });
            $.ajax({ //使用ajax与服务器异步交互
                url:"/system/role_menu/?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
                type:"PUT",
                data: {roleId:roleId,menuIds:menuIds},
                dataType:"json",
                error:function(XMLHttpRequest,textStatus,errorThrown){
                    toastr.error('网络连接失败！');
                }, //错误提示

                success:function(data){ //data为交互成功后，后台返回的数据
                    if (data.flag){
                        toastr.success(data.msg);
                    }
                }
            });
        }
	</script>
</body>
</html>