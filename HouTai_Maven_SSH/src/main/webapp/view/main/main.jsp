<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.alibaba.fastjson.JSONArray"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
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
 <!-- 顶部开始 -->
    <div class="container">
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
        <ul class="layui-nav right" lay-filter="" >
          <li class="layui-nav-item">
            <a href="javascript:;" style="padding-right: 60px;">当前用户:${sessionScope.user.uname}</a>
            <dl class="layui-nav-child"> 
            <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('个人信息','login_geren.action',600,400)">个人信息</a></dd>
              <dd><a onclick="gdsession ()">退出</a></dd>
            </dl>
          </li>
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
        <%@page import="com.Menu.action.Menu"%>
				<%@page import="java.util.Map"%>
				<% Menu menu=new Menu();
					String AllMenu=menu.getall();
					JSONArray jstr=JSONArray.parseArray(AllMenu);
				for(int i=0;i<jstr.size();i++){
					Map<String,String> map=(Map)jstr.get(i);
					
					out.println("<li><a _href='"+map.get("DESCRIBE")+"'><i class='iconfont'>&#xe6b8;</i> <cite>"+map.get("MNAME")+"</cite><i class='iconfont nav_right'>&#xe697;</i></a></li>");
					
				}
			%>
        </ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li>主页</li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright" align="center">TS小组版权所属  盗版必究</div>  
    </div>
    <!-- 底部结束 -->
</body>
<script type="text/javascript">
function gdsession () {
	$.ajax({
		 url:"login_resession.action",//请求的url地址
		 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
		 type:"POST",//请求方式
		 contentType: "application/x-www-form-urlencoded; charset=utf-8",//解决中文乱码问题  
		 success:function(date){
			 if(date=="success"){
				 window.location.reload();
			 }else {
				 alert("失败");
			}
		  },
		  error:function(date){
			alert(date);
		  }
	});
	};


</script>
</html>