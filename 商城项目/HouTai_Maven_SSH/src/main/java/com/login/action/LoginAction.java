package com.login.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.houtai.Common.action.CommonAction;

/** 
* @ClassName: login 
* @Description: TODO(员工操作 t_user) 
* @author Huang Ti Long 
* @date 2017年12月4日 上午8:48:41 
*  
*/
@Controller
@Scope("prototype")
public class LoginAction extends CommonAction{
	public String tzgetll() {
		return "mian";
		
	}
	public String geren() {
		return "geren";
	}
	public String Usergetall() throws IOException {
		String totalPage=request.getParameter("totalPage");
		if (totalPage!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("totalPage", totalPage);
		}
		return "Usergetll";
	}
	public String tzadd() {
		return "tzadd";
	}
	public String tzqx() {
		qxusid=request.getParameter("usid");
		return "tzqx";
	}
	public void resession() throws IOException {
		HttpSession session = request.getSession();
		String string="";
		try {
			session.removeAttribute("user");
			session.removeAttribute("zhiwu");
		} catch (Exception e) {
			string="error";
		}
		string="success";
		response.getWriter().write(string);
	}
	public String qx() {
		String urlNameString = "http://127.0.0.1:8080/DongMaven/t_ROLE/all";
		String result="";
		try {
			// 根据地址获取请求
			HttpGet request = new HttpGet(urlNameString);//这里发送get请求
			// 获取当前客户端对象
			HttpClient client = HttpClientBuilder.create().build();
			// 通过请求对象获取响应对象
			HttpResponse response = client.execute(request);
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result= EntityUtils.toString(response.getEntity(),"utf-8");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		System.out.println(result);
		return result;
	}
	public void fyqx() throws Exception {
		String usid=request.getParameter("usid");
		String urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/dongall?userid="+usid+"";
		String result="";
		try {
			// 根据地址获取请求
			HttpGet request = new HttpGet(urlNameString);//这里发送get请求
			// 获取当前客户端对象
			HttpClient client = HttpClientBuilder.create().build();
			// 通过请求对象获取响应对象
			HttpResponse response = client.execute(request);
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result= EntityUtils.toString(response.getEntity(),"utf-8");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray jsonArray =JSONArray.parseArray(result);
		JSONObject object=(JSONObject) jsonArray.get(0);
		String urid=object.getString("urid");
		String rid=request.getParameter("rid");
		urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/truupdate?userid="+usid+"&rid="+rid+"&urid="+urid+"";
		result="";
		try {
			// 根据地址获取请求
			HttpGet request = new HttpGet(urlNameString);//这里发送get请求
			// 获取当前客户端对象
			HttpClient client = HttpClientBuilder.create().build();
			// 通过请求对象获取响应对象
			HttpResponse response = client.execute(request);
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result= EntityUtils.toString(response.getEntity(),"utf-8");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		System.out.println(result);
		response.getWriter().write(result);
	}
	public String tzupd() throws Exception {
		String usid=request.getParameter("usid");
		String urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/oneselect?usid="+usid+"";
		String result="";
		try {
			// 根据地址获取请求
			HttpGet request = new HttpGet(urlNameString);//这里发送get请求
			// 获取当前客户端对象
			HttpClient client = HttpClientBuilder.create().build();
			// 通过请求对象获取响应对象
			HttpResponse response = client.execute(request);
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result= EntityUtils.toString(response.getEntity(),"utf-8");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray=JSONArray.parseArray(result);
		JSONObject jsonObject=JSONObject.parseObject(jsonArray.get(0).toString());
		map=jsonObject;
		return "upd";
	}
	public void login() throws Exception {
		HttpSession session = request.getSession();
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		System.out.println("uname："+uname);
		System.out.println("upwd："+upwd);
		String urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/login?uname="+uname+"&upwd="+upwd+"";
		String result="";
		try {
			// 根据地址获取请求
			HttpGet request = new HttpGet(urlNameString);//这里发送get请求
			// 获取当前客户端对象
			HttpClient client = HttpClientBuilder.create().build();
			// 通过请求对象获取响应对象
			HttpResponse response = client.execute(request);
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result= EntityUtils.toString(response.getEntity(),"utf-8");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		System.out.println(result);
		JSONArray jsonArray=JSONArray.parseArray(result);
		JSONObject jsonObject=JSONObject.parseObject(jsonArray.get(0).toString());
		map=jsonObject;
		if(map.size()==0) {
			result="账号密码错误";
		}else {
			urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/manfiveall?uname="+uname+"";
			result="";
			try {
				// 根据地址获取请求
				HttpGet request = new HttpGet(urlNameString);//这里发送get请求
				// 获取当前客户端对象
				HttpClient client = HttpClientBuilder.create().build();
				// 通过请求对象获取响应对象
				HttpResponse response = client.execute(request);
				// 判断网络连接状态码是否正常(0--200都数正常)
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					result= EntityUtils.toString(response.getEntity(),"utf-8");
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.setCharacterEncoding("utf-8");
			System.out.println(result);
			jsonArray=JSONArray.parseArray(result);
			jsonObject=JSONObject.parseObject(jsonArray.get(0).toString());
			Map map2=jsonObject;
			session.setAttribute("zhiwu", map2);
		}
		result="success";
		session.setAttribute("user", map);
		response.getWriter().write(result);
	}
	
	public void add() throws Exception {
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		String urealname=request.getParameter("urealname");
		String uphone=request.getParameter("uphone");
		String urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/saveof?uname="+uname+"";
		String result="";
		try {
			// 根据地址获取请求
			HttpGet request = new HttpGet(urlNameString);//这里发送get请求
			// 获取当前客户端对象
			HttpClient client = HttpClientBuilder.create().build();
			// 通过请求对象获取响应对象
			HttpResponse response = client.execute(request);
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result= EntityUtils.toString(response.getEntity(),"utf-8");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (result.equals("success")) {
			
		}else if(result.equals("error")){
			urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/save?uname="+uname+"&upwd="+upwd+"&urealname="+urealname+"&uphone="+uphone+"";
			result="";
			try {
				// 根据地址获取请求
				HttpGet request = new HttpGet(urlNameString);//这里发送get请求
				// 获取当前客户端对象
				HttpClient client = HttpClientBuilder.create().build();
				// 通过请求对象获取响应对象
				HttpResponse response = client.execute(request);
				// 判断网络连接状态码是否正常(0--200都数正常)
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					result= EntityUtils.toString(response.getEntity(),"utf-8");
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.setCharacterEncoding("utf-8");
			System.out.println(result);
		}
		response.getWriter().write(result);
		zidongfuyu(result, urlNameString, upwd, uname);
	}
	public void zidongfuyu(String result,String urlNameString,String upwd,String uname) {
		if (result.equals("success")) {
			urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/login?uname="+uname+"&upwd="+upwd+"";
			result="";
			try {
				// 根据地址获取请求
				HttpGet request = new HttpGet(urlNameString);//这里发送get请求
				// 获取当前客户端对象
				HttpClient client = HttpClientBuilder.create().build();
				// 通过请求对象获取响应对象
				HttpResponse response = client.execute(request);
				// 判断网络连接状态码是否正常(0--200都数正常)
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					result= EntityUtils.toString(response.getEntity(),"utf-8");
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.setCharacterEncoding("utf-8");
			System.out.println(result);
			JSONArray jsonArray=JSONArray.parseArray(result);
			JSONObject jsonObject=(JSONObject) jsonArray.get(0);
			String userid=jsonObject.getString("usid");
			String rid="4";
			urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/keyall?userid="+userid+"&rid="+rid+"";
			result="";
			try {
				// 根据地址获取请求
				HttpGet request = new HttpGet(urlNameString);//这里发送get请求
				// 获取当前客户端对象
				HttpClient client = HttpClientBuilder.create().build();
				// 通过请求对象获取响应对象
				HttpResponse response = client.execute(request);
				// 判断网络连接状态码是否正常(0--200都数正常)
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					result= EntityUtils.toString(response.getEntity(),"utf-8");
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void upd() throws Exception {
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		String urealname=request.getParameter("urealname");
		String uphone=request.getParameter("uphone");
		String usid=request.getParameter("usid");
		String urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/update?uname="+uname+"&upwd="+upwd+"&urealname="+urealname+"&uphone="+uphone+"&usid="+usid+"";
		String result="";
		try {
			// 根据地址获取请求
			HttpGet request = new HttpGet(urlNameString);//这里发送get请求
			// 获取当前客户端对象
			HttpClient client = HttpClientBuilder.create().build();
			// 通过请求对象获取响应对象
			HttpResponse response = client.execute(request);
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result= EntityUtils.toString(response.getEntity(),"utf-8");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		System.out.println(result);
		response.getWriter().write(result);
	}
	public String getall() throws Exception {
		HttpSession session = request.getSession();
		String totalPage=(String) session.getAttribute("totalPage");
		String urlNameString=null;
		if (totalPage==null) {
			urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/page";
		}else {
			urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/page?currentPage="+totalPage+"";
		}
		System.out.println("进入查询全部员工表");
		String result="";
		try {
			// 根据地址获取请求
			HttpGet request = new HttpGet(urlNameString);//这里发送get请求
			// 获取当前客户端对象
			HttpClient client = HttpClientBuilder.create().build();
			// 通过请求对象获取响应对象
			HttpResponse response = client.execute(request);
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result= EntityUtils.toString(response.getEntity(),"utf-8");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray=JSONArray.parseArray(result);
		JSONObject ob  = (JSONObject) jsonArray.get(0);//得到json对象
		String  pagemsg= ob.getString("pagemsg");
		JSONObject jsonObject=JSONObject.parseObject(pagemsg);
		currPage= jsonObject.getString("currPage");
		session.setAttribute("totalPage", currPage);
		totalPage= jsonObject.getString("totalPage");
		session.setAttribute("Page", totalPage);
		
		String  lists= jsonObject.getString("lists");
		JSONArray jsonArray2=JSONArray.parseArray(lists);
		List list=new ArrayList();
		for(int i=0;i<jsonArray2.size();i++){
			Map<String,String> map=(Map)jsonArray2.get(i);
			System.out.println("map"+map.toString());
			list.add(map);
		}
		System.out.println("list"+list.toString());
		return list.toString();
	}
	public void del() throws Exception {
		String usid=request.getParameter("usid");
		String urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/del?usid="+usid+"";
		String result="";
		try {
			// 根据地址获取请求
			HttpGet request = new HttpGet(urlNameString);//这里发送get请求
			// 获取当前客户端对象
			HttpClient client = HttpClientBuilder.create().build();
			// 通过请求对象获取响应对象
			HttpResponse response = client.execute(request);
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result= EntityUtils.toString(response.getEntity(),"utf-8");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		System.out.println(result);
		response.getWriter().write(result);
	}
	 
}
