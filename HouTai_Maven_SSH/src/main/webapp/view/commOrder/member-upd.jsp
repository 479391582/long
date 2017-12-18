<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品订单</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body>

	<div class="x-body">
		<form class="layui-form" id="formone">
			<input type="hidden" name="coid" value="${map['coid']}">
			<div class="layui-form-item">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>商品名称
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_cname" name="coname" required=""
						lay-verify="nikename" value="${map['coname']}" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>商品价钱
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_cprice" name="coprice" required=""
						lay-verify="nikename" value="${map['coprice']}" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>类型
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_fid" name="cotype" required=""
						lay-verify="nikename" value="${map['cotype']}"  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>品牌
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_ctype" name="cobrand" required=""
						lay-verify="nikename" value="${map['cobrand']}" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>状态
				</label>
				<div class="layui-input-inline">
        <select name="status" lay-verify="required" lay-search="">
          <option value="${map['status']}">当前状态:${map['status']}</option>
          <option value="未派工">未派工</option>
          <option value="正在派工">正在派工</option>
          <option value="已完工">已完工</option>
        </select>
      </div>
			</div>
			<div class="layui-form-item">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>用户姓名
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_describe" name="cname" required=""
						lay-verify="nikename" value="${map['cname']}" autocomplete="off" class="layui-input">
				</div>
			</div>
				<div class="layui-form-item">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>用户电话
				</label>
				<div class="layui-input-inline">
					<input type="text" id="L_describe" name="cphone" required=""
						lay-verify="nikename" value="${map['cphone']}" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit=""
					onclick="tzapply()">增加</button>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
function tzapply () {
	$.ajax({
		 url:"commOrder_upd.action",//请求的url地址
		 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
		 type:"POST",//请求方式
		 contentType: "application/x-www-form-urlencoded; charset=utf-8",//解决中文乱码问题  
		 data:$("#formone").serialize(),
		 success:function(date){
			 if(date=="success"){
				 parent.window.location.href="commOrder_tzgetall.action";
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