<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8;width=device-width, initial-scale=1">	
<title>Insert title here</title>

<style type="text/css">
body{font-family:Arial, Helvetica, sans-serif;background:#eee;}
.demo-box {
    margin: 100px auto;
    width: 600px;
    height:800px;
    padding: 20px;
    border: 5px solid #ccc;
	background:#fff;
	
}
.demo-table {
    border-collapse: center;
    width: 100%;
}
.demo-table caption {
    border-bottom: 1px dashed #ccc;
    height: 40px;
    margin-bottom: 20px;
	font-size:18px;line-height:1.2;
}
.demo-table tr td {
    padding: 20px 10px;
    vertical-align: top;
}
.ui-input {
    vertical-align: top;
    height: 18px;
    font-size: 16px;
    line-height: 20px;
    border: 1px solid #aaa;
    padding: 6px 8px;
    border-radius: 3px;
}
</style>
</head>
<body>
<div class="demo-box">
<form id="ff" style="align-content: center;padding-top: 15%;" >
  <table class="demo-table">
    <caption>TS维修订单</caption>
    <tr>
      <td colspan="2" align="center">
      <label for="sel_01">请选择类型:</label>
      <select  style="width:50%" id="typewei" name="rtype">
       <option value="0">--请选择--</option>
          <option value="冰箱">冰箱</option>
          <option value="电视">电视</option>
          <option value="电脑">电脑</option>
        </select>
        </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
       <label >请选择品牌:</label>
      <select style="width:50%;" id="brandwei"name="rbrand">
      <option value="0">--请选择--</option>
          <option value="联想">联想</option>
          <option value="美的">美的</option>
          <option value="海信">海信</option>
        </select></td>
    </tr>
   
   <tr>
      <td colspan="2" align="center">
       <label for="sel_01">请选择故障:</label>
      <select style="width:50%;" id="faultwei"  name="fault" >
      <option value="0">--请选择--</option>
          <option value="电脑死机">电脑死机</option>
          <option value="电视显示屏不显示">电视显示屏不显示</option>
          <option value="冰箱不会制冷">冰箱不会制冷</option>
        </select></td>
    </tr>
    
    <tr>
    
    <td colspan="2" align="center">
    详细的描述：<br/><textarea rows="5" cols="55" name="remarks"></textarea>
    
    </td>
    </tr>
		<tr>
				<td colspan="2" align="center">
					地址：
        <select id="province" onchange="show_city()" name="sheng">
              <option vlaue="河南省">河南省</option>
           
        </select>
        <select id="city" onchange="show_area()" name="shi">
              <option vlaue="郑州市">郑州市</option>
        </select>
        <select id="area" name="xian">
            <option vlaue="0">-请选择县/地区-</option>
              <option vlaue="中原区">中原区</option>
            <option vlaue="二七区">二七区</option>
            <option vlaue="管城回族区">管城回族区</option>
            <option vlaue="金水区">金水区</option>
            <option vlaue="郑东新区">郑东新区</option>
        </select>
        <br/>
        <div style="position: relative;left: -1px;">
				<label>街道:</label>
				<input type="text" name="jie" style="width: 260px"/>
			</div>
				<br/>
			
				</td>
			</tr>
		
		</table>
	
		<div style="text-align:center;padding:5px">
	    	<button type="button" onclick="tijiao()">提交</button>
	    	<button>取 消</button>
	    </div>
	    </form>
</div>
<script src="js/jquery-1.8.2.js"></script>

<script type="text/javascript">

function tijiao(){
	$.ajax({
		 url:"login_save.action",//请求的url地址
		 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
		 type:"GET",//请求方式
		 data:$("#ff").serialize(),
		 contentType: "application/x-www-form-urlencoded; charset=utf-8",
		 success:function(date){
			 if(date=="success"){
				 alert("成功提交");
				 window.location.reload();
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