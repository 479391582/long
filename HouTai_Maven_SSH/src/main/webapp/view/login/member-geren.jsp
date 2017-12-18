<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
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
    
  <div class="x-body" >
        <form class="layui-form" id="formone" >
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="x-red">*</span>用户名
              </label>
               <label for="L_username" class="layui-form-label">
             ${sessionScope.user.uname}
             </label>
          </div>
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>职务
              </label>
              <label for="L_username" class="layui-form-label">
              ${sessionScope.zhiwu.RNAME}
               </label>
          </div>
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>真实姓名
              </label>
               <label for="L_username" class="layui-form-label">
              ${sessionScope.zhiwu.UREALNAME}
               </label>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>手机号码
              </label>
              <label for="L_username" class="layui-form-label">
             ${sessionScope.user.uphone}
              </label>
          </div>
      </form>
    </div>
</body>
<script type="text/javascript">
function tzapply () {
	$.ajax({
		 url:"login_add.action",//请求的url地址
		 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
		 type:"POST",//请求方式
		 dataType:"text",
		 contentType: "application/x-www-form-urlencoded; charset=utf-8",//解决中文乱码问题  
		 data:$("#formone").serialize(),
		 success:function(date){
			 if(date=="success"){
				 parent.window.location.href="login_Usergetall.action";
				 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                 parent.layer.close(index);
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