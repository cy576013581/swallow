<div class="topleft">
    <a href="main.html" target="_parent"><img src="../images/swallow.png" style="float: left;height:50px;width:50px;" title="系统首页" /></a>
	<div style="color: #fff;font-size: 14pt;float: left;height: 50px;line-height: 50px;margin-left: 20px;">${SYS_NAME}</div>
</div>
<div class="topright">
    <ul>
	    <li><a href="#" onclick="addTabs('在线列表','/online')">在线人数：${activeNum}</a></li>
	    <li><a href="javascript:void(0);" onclick="loginOut()" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
	    <span>${user.c_username}</span>
	    <i>消息</i>
	    <b>5</b>
    </div>    
</div>

<script type="text/javascript">
	$(function(){	
		//顶部导航切换
		$(".nav li a").click(function(){
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		});
	});
	
	function loginOut(){
		window.location.href="/loginOut";
	}
</script>