<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎页面-X-admin2.0</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
	<link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body>
	<div class="x-nav">
		 <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<button class="layui-btn"
			onclick="x_admin_show('添加用户','commodity_tzadd.action',600,400)">
			<i class="layui-icon"></i>添加
		</button>
		
		<table class="layui-table" id="mytable">
			<thead>
				<tr>
					<th>
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th>ID</th>
					<th>商品名称</th>
					<th>商品价钱</th>
					<th>父id</th>
					<th>类型</th>
					<th>品牌</th>
					<th>描述</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<%@page import="com.alibaba.fastjson.JSONArray"%>
			 <%@page import="com.commodity.action.CommodityAction"%>
				<%@page import="java.util.Map"%>
				<% CommodityAction commodityAction=new CommodityAction();
					String Allcommodity=commodityAction.getall();
					JSONArray jstr=JSONArray.parseArray(Allcommodity);
				for(int i=0;i<jstr.size();i++){
					Map<String,String> map=(Map)jstr.get(i);
					out.println("<tr><td><div class='layui-unselect layui-form-checkbox' lay-skin='primary'data-id='2'><i class='layui-icon'>&#xe605;</i></div></td><td>"+map.get("cid")+"</td><td>"+map.get("cname")+"</td><td>"+map.get("cprice")+"</td><td>"+map.get("fid")+"</td><td>"+map.get("ctype")+"</td><td>"+map.get("cbrand")+"</td><td>"+map.get("describe")+"</td><td><input type='button' value='修改'  onclick='upd("+map.get("cid")+")'>&nbsp;&nbsp;&nbsp;<input type='button' value='删除'  onclick='delAll("+map.get("cid")+")'></td></tr>");}
			%>
			</tbody>
		</table>
		<div class="page">
				<div>
			<c:choose>
			<c:when test="${sessionScope.totalPage=='0'}">
				<a class="num" href="commodity_tzgetall.action?totalPage=0" >首页</a> 
			</c:when>
			<c:otherwise> 
    		 <a class="num" href="commodity_tzgetall.action?totalPage=${sessionScope.totalPage-1}" >上一页</a> 
   			</c:otherwise>
   			</c:choose>
   			<c:choose>
   			<c:when test="${sessionScope.CommodityAction-1==sessionScope.totalPage}">
   			
   			</c:when>
   			<c:otherwise> 
			<a class="num" href="commodity_tzgetall.action?totalPage=${sessionScope.totalPage+1}">下一页</a>
			</c:otherwise>
			</c:choose>
		</div>

	</div>
	<script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });
        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });
      function delAll (argument) {
            $.ajax({
                url:"commodity_del.action",
            	async :false,
                type:"post",
                data:{"cid":argument}, 
                success:function(data){
               	 	window.location.reload();
                },
                error:function(e){
                    alert("错误！！");
                }
            });
      }
      function upd (argument) {
           x_admin_show("修改用户","commodity_tzupd.action?cid="+argument+"",600,400);
    	  };  
    </script>
</body>
</html>