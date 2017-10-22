<div id="left" style="background:#f0f9fd;">
	<div class="lefttop"><span></span>菜单</div>
	<dl class="leftmenu">
		<#list menuList?keys as key>
		  	<dd>
			    <div class="title">
			    <span><img src="../images/leftico01.png" /></span>${key}
			    </div>
		    	<ul class="menuson">
		    		<#assign map=menuList[key] >
		    		<#list map as menu> 
				        <li><cite></cite><a href="javascript:void(0);" onclick="addTabs('${menu.c_menuName}','${menu.c_url}')">${menu.c_menuName}</a><i></i></li>
			        </#list>
		        </ul>    
		    </dd>
		</#list>
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
