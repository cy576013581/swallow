<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>欢迎登录后台管理系统</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script src="js/jquery.min.js" language="JavaScript"></script>
	<script src="js/cloud.js" type="text/javascript"></script>
	
	<script language="javascript">
		$(function(){
		    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
			$(window).resize(function(){  
			    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		    });
		});  
		
		function login(){
			var username = $(".loginuser").val();
			var pwd = $(".loginpwd").val();
			if(username == ""){
				alert("用户名不能为空！");
				return;
			}
			if(pwd == ""){
				alert("密码不能为空！");
				return;
			}
			$.ajax({ //使用ajax与服务器异步交互 
                url:"system/user/validate?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
                type:"POST",
                async:false,
                data: {username:username,password:pwd}, //$('#yourformid').serialize()；向后台发送的form表单中的数据
                dataType:"json", //接收返回的数据方式为json
                error:function(XMLHttpRequest,textStatus,errorThrown){
                }, //错误提示

                success:function(data){ //data为交互成功后，后台返回的数据
                    var flag =data.flag;//服务器返回标记
                    if(flag){
                    	alert(data.msg);
                    	window.location.href="/main";
                    }else {
                    	alert(data.msg);
					}
                }
            });
		}
		
		function keyDown(){
		  	if (window.event.keyCode == 13)
		 	{
		    	$(".loginbtn").click();
		  	}
		}
		
	</script>

</head>

<body onkeydown="keyDown()" style="background-color:#1c77ac; background-image:url(${pageContext.request.contextPath }/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


	<div class="logintop">    
	    <span>欢迎登录后台管理界面平台</span>    
	    <ul>
	    <li><a href="#">回首页</a></li>
	    <li><a href="#">帮助</a></li>
	    <li><a href="#">关于</a></li>
	    </ul>    
	</div>
	    
	<div class="loginbody">
	    <span class="systemlogo"></span> 
	    <div class="loginbox">
			    <ul>
				    <li><input name="c_username" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
				    <li><input name="c_pwd" type="password" class="loginpwd" placeholder="密码" onclick="JavaScript:this.value=''"/></li>
				    <li><input type="button" class="loginbtn" value="登录"  onclick="login()"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
			    </ul>
	    </div>
    </div>
    <div class="loginbm">版权所有  swallow</div>
</body>
</html>
