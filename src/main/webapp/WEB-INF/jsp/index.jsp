<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>登陆界面</title>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="css/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
	
	<style type="text/css">
        .second {
            color: #fff;
            font-weight: bold;
            font-family: georgia, serif; 
        }
    </style>
	
  </head>

  <body> 
    
    <div class="navbar">
        <div class="navbar-inner">
                <span class="brand"><span class="second">无记名国债兑付管理系统</span></span>
        </div>
    </div>
    <div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">用户登录</p>
				<div class="block-body">
					<form id="form">
						<label>金融机构代码</label>
						<input type="text" name="code" class="span12" value="A1000141000278">
						<label>金融机构名称</label>
						<input type="text" name="name" class="span12" value="中国人民银行驻马店市中心支行">
						<label>系统登录密码</label>
						<input type="password" name="password" class="span12" value="123456">
						<center><a href="#" onclick="login()" class="btn btn-primary">登陆</a></center>
					</form>
				</div>
			</div>
		</div>
	</div>
    <script type="text/javascript">
		function login(){
			$.ajax({ //使用ajax与服务器异步交互
    	        url:"Login?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
    	        type:"POST",
    	        data: $('#form').serialize(), 
    	        dataType:"json", //接收返回的数据方式为json
    	        error:function(XMLHttpRequest,textStatus,errorThrown){
    	            alert("网络错误！");
    	        }, //错误提示
    	        success:function(data){ //data为交互成功后，后台返回的数据
    	        	if(data.flag){
    	        		window.location.href="main.html";
    	        	}else{
    	        		alert("信息填写错误，登录失败！");
    	        	}
    	        }
    	    });
		}
    </script>
    
  </body>
</html>



