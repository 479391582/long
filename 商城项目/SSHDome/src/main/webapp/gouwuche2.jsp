<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="org.apache.taglibs.standard.*"%>
<%@ page language="java" import="javax.servlet.jsp.jstl.*" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
input {
	width: 60px;
	text-align: center;
}
#li{
	margin-left: 8%;
	float:left;
}
#s{
margin-left: 20%;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="page-header">
				<h2>购物车  *^.^*</h2>
			</div>
		</div>
		<form action="">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<table class="table table-hover" id="aa">
					<tr>
						<td><b>品牌</b></td>
						<td><b>商品名</b></td>
						<td><b>单价</b></td>
						<td><b>性能</b></td>
						<td><b>操作</b></td>
					</tr>
					<tr id="dd" style="border: 1px solid;">
					</tr>
				</table>
				<div>
				<ul style="list-style-type:none">
				<li id="li"><span id="price"></span></li>
				<li id="li"><a href="coom_dd.action">查询订单</a></li>
				<li id="li"><a href="coom_delall.action">清空购物车</a></li>
				<li id="li"><a href="login_shouye.action">返回首页</a></li>
						</ul>
				</div>
			</div>
		</div>
		</form>
	</div>
	<div style="margin-left: 28%; margin-top: 20%;">
	<h4 >友情提示：如有订单问题请联系商家处理订单拨打电话：1873787***1</h4>
	</div>
	<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/custom.js"></script>
	<script type="text/javascript">
	$.ajax({
		url:"coom_sall.action",    //è¯·æ±çurlå°å
	    dataType:"json",   //è¿åæ ¼å¼ä¸ºjson
	    contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
	    async:true,//è¯·æ±æ¯å¦å¼æ­¥ï¼é»è®¤ä¸ºå¼æ­¥ï¼è¿ä¹æ¯ajaxéè¦ç¹æ§
	    type:"POST",
	    cache:false,
	    success:function(data){ 
	    	var html = "";
	    	for(var i=0; i<data.length; i++){
	    		var ls = data[i];
	    		 html="<tr><td>"+ls.shbrand+"</td><td>"+ls.shname+"</td><td>"+ls.shprice+"</td><td>"+ls.shdescribe+"</td><td><a href='coom_del.action?shid="+ls.shid+"'>删除</td></tr>";
	    		 $("#aa").append(html);
	    	}
	    	var c=0;
	    	for(var i=0; i<data.length; i++){
	    		c+=parseInt(data[i].shprice);
	    		var z="<span>总价："+c+"元</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='coom_tijiao.action?shid="+ls.shid+"'>提交订单</a>";
	    	}
	    	$("#price").html(z);
	}
	    
		})
		
		</script>
</body>

</html>