<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>维修订单</title>
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
					<th>类型</th>
					<th>品牌</th>
					<th>故障信息</th>
					<th>备注</th>
					<th>状态 </th>
					<th>用户姓名</th>
					<th>用户电话</th>
					<th>用户地址</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<%@page import="com.alibaba.fastjson.JSONArray"%>
			 <%@page import="com.RepairOrder.action.RepairOrder"%>
				<%@page import="java.util.Map"%>
				<% RepairOrder repairOrder=new RepairOrder();
					String Allcommodity=repairOrder.getall();
					JSONArray jstr=JSONArray.parseArray(Allcommodity);
					Map map2=(Map) session.getAttribute("zhiwu");
					String RNAME=(String) map2.get("RNAME");
					if(RNAME.equals("超级管理")){
						for(int i=0;i<jstr.size();i++){
							Map<String,String> map=(Map)jstr.get(i);
							out.println("<tr><td><div class='layui-unselect layui-form-checkbox' lay-skin='primary'data-id='2'><i class='layui-icon'>&#xe605;</i></div></td><td>"+map.get("REID")+"</td><td>"+map.get("RTYPE")+"</td><td>"+map.get("RBRAND")+"</td><td>"+map.get("FAULT")+"</td><td>"+map.get("REMARKS")+"</td><td>"+map.get("STATUS")+"</td><td>"+map.get("CREALNAME")+"</td><td>"+map.get("CPHONE")+"</td><td>"+map.get("ADDRESS")+"</td><td><input type='button' value='修改'  onclick='upd("+map.get("REID")+")'>&nbsp;&nbsp;&nbsp;<input type='button' value='删除'  onclick='delAll("+map.get("REID")+")'></td></tr>");}
						}
					else if(RNAME.equals("维修人员")){
						for(int i=0;i<jstr.size();i++){
							Map<String,String> map=(Map)jstr.get(i);
							String status=map.get("STATUS");	
							if(status.equals("未派工")){
								out.println("<tr><td><div class='layui-unselect layui-form-checkbox' lay-skin='primary'data-id='2'><i class='layui-icon'>&#xe605;</i></div></td><td>"+map.get("REID")+"</td><td>"+map.get("RTYPE")+"</td><td>"+map.get("RBRAND")+"</td><td>"+map.get("FAULT")+"</td><td>"+map.get("REMARKS")+"</td><td>"+map.get("STATUS")+"</td><td>"+map.get("CREALNAME")+"</td><td>"+map.get("CPHONE")+"</td><td>"+map.get("ADDRESS")+"</td><td><input type='button' value='接单'  onclick='caozuo("+map.get("REID")+")'></td></tr>");}
						else if(status.equals("正在派工")){
							out.println("<tr><td><div class='layui-unselect layui-form-checkbox' lay-skin='primary'data-id='2'><i class='layui-icon'>&#xe605;</i></div></td><td>"+map.get("REID")+"</td><td>"+map.get("RTYPE")+"</td><td>"+map.get("RBRAND")+"</td><td>"+map.get("FAULT")+"</td><td>"+map.get("REMARKS")+"</td><td>"+map.get("STATUS")+"</td><td>"+map.get("CREALNAME")+"</td><td>"+map.get("CPHONE")+"</td><td>"+map.get("ADDRESS")+"</td><td><input type='button' value='已完工'  onclick='caozuo("+map.get("REID")+")'><input type='button' value='地图'  onclick='ddd("+map.get("CID")+")'></td></tr>");
						}else if(status.equals("已完工")){
							out.println("<tr><td><div class='layui-unselect layui-form-checkbox' lay-skin='primary'data-id='2'><i class='layui-icon'>&#xe605;</i></div></td><td>"+map.get("REID")+"</td><td>"+map.get("RTYPE")+"</td><td>"+map.get("RBRAND")+"</td><td>"+map.get("FAULT")+"</td><td>"+map.get("REMARKS")+"</td><td>"+map.get("STATUS")+"</td><td>"+map.get("CREALNAME")+"</td><td>"+map.get("CPHONE")+"</td><td>"+map.get("ADDRESS")+"</td></tr>");}
						}
						}
			%>
			</tbody>
		</table>
		<div class="page">
			<div>
			<c:choose>
			<c:when test="${sessionScope.totalPage=='0'}">
				<a class="num" href="repairOrder_tzgetall.action?totalPage=0" >首页</a> 
			</c:when>
			<c:otherwise> 
    		 <a class="num" href="repairOrder_tzgetall.action?totalPage=${sessionScope.totalPage-1}" >上一页</a> 
   			</c:otherwise>
   			</c:choose>
   			<c:choose>
   			<c:when test="${sessionScope.RepairOrder-1==sessionScope.totalPage}">
   			
   			</c:when>
   			<c:otherwise> 
			<a class="num" href="repairOrder_tzgetall.action?totalPage=${sessionScope.totalPage+1}">下一页</a>
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
                url:"repairOrder_del.action",
            	async :false,
                type:"post",
                data:{"reid":argument}, 
                success:function(data){
                	if(data=="success"){
                		window.location.reload();
                	}else {
                		alert(data);
					}
                	
                },
                error:function(e){
                    alert("错误！！");
                }
            });
      }
      function caozuo (argument,status) {
          $.ajax({
              url:"repairOrder_caozuo.action",
          	async :false,
              type:"post",
              data:{"reid":argument}, 
              success:function(data){
             	 	window.location.reload();
              },
              error:function(e){
                  alert("错误！！");
              }
          });
    }
      function upd (argument) {
           x_admin_show("修改订单","repairOrder_tzupd.action?reid="+argument+"",600,400);
    	  };  
    	  function ddd (aa) {
               x_admin_show("地图","commOrder_tzditu.action?weizhi="+aa+"",800,600);
        	  }; 
    	  
    	  
    </script>
</body>
</html>