<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8;width=device-width, initial-scale=1">
<title>登陆</title>

<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/supersized.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body oncontextmenu="return false">
	<div class="page-container" id="deng">
		<h1>用户登陆</h1>
		<form id="formone">
			<div>
				<input type="text" id="cname" name="custumer.cname" placeholder="用户名"/>
			</div>
			<div>
				<input type="password" id="cpwd" name="custumer.cpwd" placeholder="密码" />
			</div>
			<button type="button" onclick="tizapply()">登陆</button>
			
		</form>
		<div class="connect">
			<p>If we can only encounter each other rather than stay with each
				other,then I wish we had never encountered.</p>
			<p style="margin-top: 20px;">如果只是遇见，不能停留，不如不遇见。</p>
		</div>
	</div>
	<script src="js/jquery-1.8.2.js"></script>
	<script src="js/supersized.3.2.7.min.js"></script>
	<script src="js/supersized-init.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){  
	    //初始化宽度、高度  
	    $("#deng").width($(window).width());  
	    $("#deng").height($(window).height());  
	    //当文档窗口发生改变时 触发  
	    $(window).resize(function(){  
	        $("#deng").width($(window).width());  
	        $("#deng").height($(window).height());  
	    })  
	    })
	    
window.onload = function()
{
	$(".connect p").eq(0).animate({"left":"0%"}, 600);
	$(".connect p").eq(1).animate({"left":"0%"}, 400);
}
function is_show(){ $(".alert").show().animate({"top":"45%"}, 300) }
function tizapply() {
	$.ajax({
		 url:"login_login.action",//请求的url地址
		 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
		 type:"GET",//请求方式
		 dataType:"text",
		 contentType: "application/x-www-form-urlencoded; charset=utf-8",//解决中文乱码问题  
		 data:$("#formone").serialize(),
		 success:function(date){
			 if(date=="success"){
				 
				 location.href = "login_tzgetll.action";//location.href实现客户端页面的跳转 
			 }else {
				 alert("用户名或密码不正确");
			}
			 
		  },
		  error:function(date){
			alert(date);
		  }
	});
	};
</script>
</body>

</html>