<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>信息管理系统界面</title>
	<link rel="stylesheet" type="text/css" href="../lib/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../lib/easyui/themes/icon.css">
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../lib/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		
		//增加tabs
		function addTabs(title,url){
			if($("#mainTabs").tabs('exists', title))
			{
				$('#mainTabs').tabs('select',title);
			}
			else
			{
				var content = '<iframe src="'+url+'" id="iframe" width="100%" height="100%" frameborder="0"></iframe>';
				$('#mainTabs').tabs('add',{
				    title:title,
				    content:content,
				    closable:true
				});
			}
		}
		
		 //删除Tabs
		  function closeTab(menu, type) {
            var allTabs = $("#mainTabs").tabs('tabs');
            var allTabtitle = [];
            $.each(allTabs, function (i, n) {
                var opt = $(n).panel('options');
                if (opt.closable)
                    allTabtitle.push(opt.title);
            });
            var curTabTitle = $(menu).data("tabTitle");
            var curTabIndex = $("#mainTabs").tabs("getTabIndex", $("#mainTabs").tabs("getTab", curTabTitle));
            switch (type) {
                case 1://关闭当前
                    $("#mainTabs").tabs("close", curTabIndex);
                    break;
                case 2://全部关闭
                    for (var i = 0; i < allTabtitle.length; i++) {
                        $('#mainTabs').tabs('close', allTabtitle[i]);
                    }
                    break;
                case 3://除此之外全部关闭
                    for (var i = 0; i < allTabtitle.length; i++) {
                        if (curTabTitle != allTabtitle[i])
                            $('#mainTabs').tabs('close', allTabtitle[i]);
                    }
                    $('#mainTabs').tabs('select', curTabTitle);
                    break;
                case 4://当前侧面右边
                    for (var i = curTabIndex; i < allTabtitle.length; i++) {
                        $('#mainTabs').tabs('close', allTabtitle[i]);
                    }
                    $('#mainTabs').tabs('select', curTabTitle);
                    break;
                case 5: //当前侧面左边
                    for (var i = 0; i < curTabIndex - 1; i++) {
                        $('#mainTabs').tabs('close', allTabtitle[i]);
                    }
                    $('#mainTabs').tabs('select', curTabTitle);
                    break;
                case 6: //刷新
                    var panel = $("#mainTabs").tabs("getTab", curTabTitle).panel("refresh");
                    break;
            }

        }
        
        
        
  	$(document).ready(function () {
         
         //extend,将新方法写入jq的全局中
			$.extend($.fn.tabs.methods, {
			    /**
			     * 绑定双击事件
			     * @param {Object} jq
			     * @param {Object} caller 绑定的事件处理程序
			     */
			    bindDblclick: function(jq, caller){
			        return jq.each(function(){
			            var that = this;
			            $(this).children("div.tabs-header").find("ul.tabs").undelegate('li', 'dblclick.tabs').delegate('li', 'dblclick.tabs', function(e){
			                if (caller && typeof(caller) == 'function') {
			                    var title = $(this).text();
			                    var index = $(that).tabs('getTabIndex', $(that).tabs('getTab', title));
			                    caller(index, title);
			                }
			            });
			        });
	    		}
	    	});
            //监听右键事件，创建右键菜单
            $('#mainTabs').tabs({
                onContextMenu:function(e, title,index){
                    e.preventDefault();
                    if(index>0){
                        $('#mm').menu('show', {
                            left: e.pageX,
                            top: e.pageY
                        }).data("tabTitle", title);
                    }
                }
            });
            //右键菜单click
            $("#mm").menu({
                onClick : function (item) {
                    closeTab(this, item.name);
                }
            });
            //双击tabs事件
    		$('#mainTabs').tabs('bindDblclick', function(index, title){
    		 	$("#mainTabs").tabs("close", index);
  			});
		
		});
		
		
	</script>
</head>
<body>
	<!-- 顶部栏-->
	<div id="top" style="background:url(../images/topbg.gif) repeat-x;width:100%;height:auto;overflow:hidden;">
		<#include "/main/top.ftl">
	</div>
	<div id="box" width="100%" >
		<!-- 左部菜单-->
		<#include "/main/left.ftl">
		<!-- 右部主界面栏-->
		<div id="main">
			<div class="easyui-tabs" id="mainTabs" data-options="border:false" 
				style="width:100%;height:100%;">
				<div title="主页" data-options="closable:false" >
					<iframe src="/menu/home" id="iframe" width="100%" height="100%" frameborder="0"></iframe>
				</div>
			</div>
		</div>
	
	</div>
	
	<div id="mm" class="easyui-menu" style="width:120px;">
        <div id="mm-tabclose" data-options="name:1">关闭</div>
        <div id="mm-tabcloseall" data-options="name:2">全部关闭</div>
        <div id="mm-tabcloseother" data-options="name:3">除此之外全部关闭</div>
        <div class="menu-sep"></div>
        <div id="mm-tabcloseright" data-options="name:4">当前页右侧全部关闭</div>
        <div id="mm-tabcloseleft" data-options="name:5">当前页左侧全部关闭</div>
        <div id="mm-tabclose" name="6">刷新</div>
    </div>
    
</body>
</html>