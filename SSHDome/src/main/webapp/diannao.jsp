<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="org.apache.taglibs.standard.*"%>
<%@ page language="java" import="javax.servlet.jsp.jstl.*" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<title>Magnet - Minimal Portfolio Template</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">
</head>
<body>
<!-- PRE LOADER -->
<div class="preloader">
     <div class="sk-spinner sk-spinner-wordpress">
          <span class="sk-inner-circle"></span>
     </div>
</div>
<!-- Navigation section  -->
<div class="navbar navbar-default navbar-static-top" role="navigation">
     <div class="container">
          <div class="navbar-header">
               <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon icon-bar"></span>
                    <span class="icon icon-bar"></span>
                    <span class="icon icon-bar"></span>
               </button>
               <a href="index.html" class="navbar-brand"><i class="fa fa-magnet"></i></a>
          </div>
          <div class="collapse navbar-collapse">
               <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="login_shouye.action">家电首页</a></li>
                    <li><a href="login_bingxiang.action">冰箱</a></li>
                    <li><a href="login_dianshi.action">电视</a></li>
                    <li><a href="login_diannao.action">电脑</a></li>
                     <li><a href="login_gouwuche.action">我的购物车</a></li><br>
               </ul>
          </div>
  </div>
</div>


<!-- Single Project Section -->

<section id="single-project">
     <div class="container">
          <div class="row">

               <div class="col-md-offset-1 col-md-10 col-sm-12" id="cid">
                    <h1>Project title here</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>

                    <div class="col-md-12 col-sm-12">
                         <img src="images/18.jpg" class="img-responsive" alt="Portfolio">
                   
                    <div class="clearfix"></div>
                    <div class="col-md-4 col-sm-4">               
                    </div>
                    <div class="col-md-4 col-sm-4">
                       <ul id="con"  style="list-style-type:none"> 
                         	</ul>
                    </div>
                    <div class="col-md-4 col-sm-4">        
                    </div>
                    </div>
                         <img src="images/17.jpg" class="img-responsive" alt="Portfolio">
                   
                    <div class="clearfix"></div>
                    <div class="col-md-4 col-sm-4">               
                    </div>
                    <div class="col-md-4 col-sm-4">
                         <ul id="con2"  style="list-style-type:none"> 
                         	</ul>
                         	
                    </div>
                    <div class="col-md-4 col-sm-4">        
                    </div>
                     </div>
               </div>
          </div>
     </div>
</section>

<!-- Footer Section -->

<footer>
     <div class="container">
          <div class="row">

               <div class="col-md-3 col-sm-3">
                    <i class="fa fa-magnet"></i>
               </div>

                <div class="col-md-4 col-sm-4">
                    <p>Best wishes to you in this special day! Wish you forever young and beautiful! Best regards and a happy birthday to you!</p>
               </div>

               <div class="col-md-offset-1 col-md-4 col-sm-offset-1 col-sm-3">
                    <p><a href="mailto:youremail@gmail.com">hello 亲爱的客户</a></p>
                    <p>欢迎您的到来，我们将为你至高的服务</p>
               </div>

               <div class="clearfix col-md-12 col-sm-12">
                    <hr>
               </div>
  
          </div>
     </div>
</footer>


<!-- SCRIPTS -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/custom.js"></script>
<script type="text/javascript">
$.ajax({
url:"coom_all.action",    //è¯·æ±çurlå°å
dataType:"json",   //è¿åæ ¼å¼ä¸ºjson
contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
async:true,//è¯·æ±æ¯å¦å¼æ­¥ï¼é»è®¤ä¸ºå¼æ­¥ï¼è¿ä¹æ¯ajaxéè¦ç¹æ§
type:"POST",
cache:false,
data:$("#cid").serialize(),//è¯·æ±æ¹å
success:function(data){
	for(var i = 0; i < data.length; i++){
		
		var html = "";
		var ls = data[0];
		 html +="<li>品牌<h3>"+ls.cbrand+"</h3></li><li>名称<h3>"+ls.cname+"</h3></li><li>价格<h3>"+ls.cprice+"</h3></li><li><a href='coom_add.action?cid="+ls.cid+"'>添加到购物车</a></li>";
	}
	$("#con").append(html); 

for(var a = 0; a < data.length; a++){
	var html = "";
	var ls = data[5];
	 html +="<li>品牌<h3>"+ls.cbrand+"</h3></li><li>名称<h3>"+ls.cname+"</h3></li><li>价格<h3>"+ls.cprice+"</h3></li><li><a href='coom_add.action?cid="+ls.cid+"'>添加到购物车</a></li>";
}
$("#con2").html(html); 
}

})

</script>
</body>
</html>