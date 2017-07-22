<div id="left" style="background:#f0f9fd;">
	<div class="lefttop"><span></span>通讯录</div>
	<dl class="leftmenu">
	    <dd>
		    <div class="title">
		    <span><img src="../images/leftico01.png" /></span>管理信息
		    </div>
	    	<ul class="menuson">
		        <li class="active"><cite></cite><a href="javascript:void(0);" onclick="">数据列表</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="addTab('第一页','/menu/home')">图片数据表</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="">添加编辑</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="">图片列表</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="">自定义</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="">常用工具</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="">信息管理</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="">Tab页</a><i></i></li>
		        <li><cite></cite><a href="javascript:void(0);" onclick="">404页面</a><i></i></li>
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
	function addTab(title,url){
		var content = '<iframe src="'+url+'" id="iframe" width="100%" height="99%" frameborder="0"></iframe>';
		$('#mainTabs').tabs('add',{
		    title:title,
		    content:content,
		    closable:true
		});
	}
</script>
