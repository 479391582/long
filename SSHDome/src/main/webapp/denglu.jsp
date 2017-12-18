<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="org.apache.taglibs.standard.*"%>
<%@ page language="java" import="javax.servlet.jsp.jstl.*" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>登录和注册</title>
	<link rel="stylesheet" href="css/stylez.css">
	<link href="css/popup-box.css" rel="stylesheet" type="text/css" media="all" />

		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Sign In And Sign Up Forms  Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

	<script src="js/jquery.min.js"></script>
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<script type="text/javascript" src="js/modernizr.custom.53451.js"></script> 
 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
</script>	
		<style type="text/css">
			button {
    cursor: pointer;
    width: 100%;
    height: 50%;
    margin-top: 0px;
    padding: 0;
    background: #7d7d7d;
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 0px;
    -moz-box-shadow:
        0 15px 30px 0 rgba(255,255,255,.25) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:
        0 15px 30px 0 rgba(255,255,255,.25) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:
        0 15px 30px 0 rgba(255,255,255,.25) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
    font-size: 14px;
    font-weight: 700;
    color: #fff;
    text-shadow: 0 1px 2px rgba(0,0,0,.1);
    -o-transition: all .2s;
    -moz-transition: all .2s;
    -webkit-transition: all .2s;
    -ms-transition: all .2s;
}

button:hover {
    -moz-box-shadow:
        0 15px 30px 0 rgba(255,255,255,.15) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:
        0 15px 30px 0 rgba(255,255,255,.15) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:
        0 15px 30px 0 rgba(255,255,255,.15) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
}

button:active {
    -moz-box-shadow:
        0 15px 30px 0 rgba(255,255,255,.15) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:
        0 15px 30px 0 rgba(255,255,255,.15) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:        
        0 5px 8px 0 rgba(0,0,0,.1) inset,
        0 1px 4px 0 rgba(0,0,0,.1);

    border: 0px solid #ef4300;
}
		</style>
</head>
<body>
	<h1>登陆</h1>
	<div class="w3layouts">
		<div class="signin-agile">
			<h2>登陆</h2>
			<form  id="ff" >
				<input type="text" name="cname"  placeholder="用户名" required=""/>
				<input type="password" name="cpwd" placeholder="密码" required=""/>
				<div class="clear"></div>
				<button type="button" onclick="denglu()" style="height: 40px;width: 100%; ">登陆</button>
				<a href="login_shouye.action" style="margin-top: 20px;height: 50px;width: 60%;">返回首页</button>
			</form>
		</div>
		<div class="signup-agileinfo">
			<h3>注册</h3>
			<p>还好没放弃，终于等到你。</p>
			<div class="more">
				<a class="book popup-with-zoom-anim button-isi zoomIn animated" data-wow-delay=".5s" href="#small-dialog">注册</a>				
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="pop-up"> 
	<div id="small-dialog" class="mfp-hide book-form">
		<h3>注册 </h3>
			<form id="fzc">
				<input type="text" name="cname"placeholder="用户名"  required=""/>
				<input type="password" name="cpwd" class="cpwd" placeholder="密码" required=""/>
				<input type="text" name="crealname" placeholder="姓名" required=""/>
				<input type="text" name="address" placeholder="地址" required=""/>
				<input type="text" name="cphone" id="cphone" placeholder="电话" required=""/>
				<input type="text" name="code" placeholder="验证码"/>
				<button style="height: 50px;width: 50%; margin-left: 25%;" onclick="duanxin()" id="showTimes">获取验证码</button>
				<button type="button" onclick="zhuce()" style="margin-top: 20px;height: 50px;width: 100%;">注册</button>
			</form>
	</div>
</div>	
<body>
<script type="text/javascript">

function denglu(){
	$.ajax({
		type:"get",
		url:"login_login.action",
		data:$("#ff").serialize(),
		success:function(date){
			if(date=="error"){
			alert("登陆失败用户或密码错误！")
		}else {
			window.location.href="login_shouye.action";
		}
				
		},
		error:function(date){
			alert("登陆失败用户或密码错误！");
		}
	});
}


function zhuce(){
	$.ajax({
		type:"get",
		url:"login_zhuce.action",
		data:$("#fzc").serialize(),
		success:function(date){
			if(date=="success"){
				alert("注册成功")
			}else {
				alert("注册失败")
			}
			
		},
		error:function(date){
			alert("注册失败");
		}
	});
}


function duanxin() {
	$("#showTimes").attr("disabled","disabled");
	var cphone =  document.getElementById("cphone").value;
	$.ajax({
		type:"get",
		url:"login_duanxin.action",
		data:{"cphone":cphone},
		success:function(date){
		},
		error:function(date){
			alert(date);
		}
	});
	var second = <%= 1 * 3000%>; // 剩余秒数
	// 写一个方法，将秒数专为天数
	var s;
	var toDays = function(){
	  s = second % 60; // 秒
	 //var mi = (second - s) / 60 % 60; // 分钟
	 //var h = ((second - s) / 60 - mi ) / 60 % 24; // 小时
	// var d = (((second - s) / 60 - mi ) / 60 - h ) / 24;  // 天
	return "剩余："+ s + "秒";
	}
	//然后写一个定时器
	var time = window.setInterval(function(){
	 second --;
	 document.getElementById("showTimes").innerHTML = toDays ();
	 if(s==00){
		 clearInterval(time);
		 $("#showTimes").attr("disabled",false);
		 document.getElementById("showTimes").innerHTML="再次获取验证码";
	 }
	}, 1000);
}
</script>
</html>