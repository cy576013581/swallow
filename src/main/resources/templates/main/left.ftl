<div id="left" style="background:#f0f9fd;">
	<div class="lefttop"><span></span>菜单</div>
	<dl class="leftmenu">
	    <dd>
		    <div class="title">
		    <span><img src="../images/leftico01.png" /></span>系统设置
		    </div>
	    	<ul class="menuson">
		        <li><cite></cite><a href="javascript:void(0);" onclick="addTabs('日程管理','/menu/calendarManage')">日程管理</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="addTabs('登录记录','/menu/loginRecordManage')">登录记录</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="addTabs('用户管理','/menu/userManage')">用户管理</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="addTabs('权限管理','/menu/permissionManage')">权限管理</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="addTabs('角色管理','/menu/roleManage')">角色管理</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="addTabs('文件上传','/menu/uploadFile')">文件上传</a><i></i></li>
		       
	        </ul>    
	    </dd>
			    
	    <dd>
		    <div class="title">
		    	<span><img src="../images/leftico02.png" /></span>其他设置
		    </div>
		    <ul class="menuson">
		        <li><cite></cite><a href="#">编辑内容</a><i></i></li>
		        <li><cite></cite><a href="#">发布信息</a><i></i></li>
		        <li><cite></cite><a href="#">档案列表显示</a><i></i></li>
	        </ul>     
	    </dd> 
			    
			    
	    <dd><div class="title"><span><img src="../images/leftico03.png" /></span>编辑器</div>
		    <ul class="menuson">
		        <li><cite></cite><a href="#">自定义</a><i></i></li>
		        <li><cite></cite><a href="#">常用资料</a><i></i></li>
		        <li><cite></cite><a href="#">信息列表</a><i></i></li>
		        <li><cite></cite><a href="#">其他</a><i></i></li>
		    </ul>    
	    </dd>  
			    
			    
	    <dd><div class="title"><span><img src="../images/leftico04.png" /></span>日期管理</div>
		    <ul class="menuson">
		        <li><cite></cite><a href="#">自定义</a><i></i></li>
		        <li><cite></cite><a href="#">常用资料</a><i></i></li>
		        <li><cite></cite><a href="#">信息列表</a><i></i></li>
		        <li><cite></cite><a href="#">其他</a><i></i></li>
		    </ul>
	    
	    </dd>   
	</dl>
</div>

<script type="text/javascript">
	$(function(){	
		//导航切换
		$(".menuson li").click(function(){
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});
		
		$('.title').click(function(){
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if($ul.is(':visible')){
				$(this).next('ul').slideUp();
			}else{
				$(this).next('ul').slideDown();
			}
		});
	});


	function addTab(title,url){
		var content = '<iframe src="'+url+'" id="iframe" width="100%" height="99%" frameborder="0"></iframe>';
		$('#mainTabs').tabs('add',{
		    title:title,
		    content:content,
		    closable:true
		});
	}
</script>
