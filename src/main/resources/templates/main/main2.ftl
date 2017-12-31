<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layui风格布局</title>
  <link rel="stylesheet" type="text/css" href="lib/easyui/themes/metro-gray/easyui.css">
  <link rel="stylesheet" type="text/css" href="lib/easyui/themes/icon.css">
  <link href="css/style.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="lib/easyui/jquery.min.js"></script>
  <script type="text/javascript" src="lib/easyui/jquery.easyui.min.js"></script>
  <link rel="stylesheet" href="/lib/layui/css/layui.css">
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
    			/*if("主页" != title){
    				$("#mainTabs").tabs("close", index);
    			}*/
  			});
		
		});
		
		
	</script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">${SYS_NAME}</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">商品管理</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          ${user.c_username}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
	      <#list menuList?keys as key>
		    <li class="layui-nav-item">
	          <a href="javascript:;">${key}</a>
	          <dl class="layui-nav-child">
	          	<#assign map=menuList[key] >
	    		<#list map as menu> 
	    			<dd><a href="javascript:;" onclick="addTabs('${menu.c_menuName}','${menu.c_url}')">${menu.c_menuName}</a></dd>
		        </#list>
	          </dl>
	    	</li>
		  </#list>
	  </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
	<div class="easyui-tabs" id="mainTabs" data-options="border:false" 
		style="width:100%;height:100%;">
		<div title="主页" data-options="closable:false" >
			<iframe src="/menu/home" id="iframe" width="100%" height="100%" frameborder="0"></iframe>
		</div>
	</div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © swallow
  </div>
</div>
<script src="/lib/layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>