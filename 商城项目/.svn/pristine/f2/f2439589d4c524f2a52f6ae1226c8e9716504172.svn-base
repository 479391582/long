package com.custumek.action;

import java.util.ArrayList;
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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.houtai.Common.action.CommonAction;

/** 
* @ClassName: Custumek 
* @Description: TODO(客户表 T_CUSTUMER) 
* @author Huang Ti Long 
* @date 2017年12月4日 上午10:08:50 
*  
*/
@Controller
@Scope("prototype")
public class Custumek extends CommonAction{
	public String tzgetall() {
		String totalPage=request.getParameter("totalPage");
		if (totalPage!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("totalPage", totalPage);
		}
		return "getall";
	}
	public String tzadd() {
		return "tzadd";
	}
	public String getall() throws Exception {
		HttpSession session = request.getSession();
		String totalPage=(String) session.getAttribute("totalPage");
		String urlNameString=null;
		if (totalPage==null) {
			urlNameString = "http://pangyan-123.gnway.cc/DongMaven/t_CUSTUMER/page";
		}else {
			urlNameString = "http://pangyan-123.gnway.cc/DongMaven/t_CUSTUMER/page?currentPage="+totalPage+"";
		}
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
		System.out.println("CustumektotalPage:"+totalPage);
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
	public String tzupd() throws Exception {
		String cid=request.getParameter("cid");
		String urlNameString = "http://pangyan-123.gnway.cc/DongMaven/t_CUSTUMER/oneselect?cid="+cid+"";
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
	public void upd() throws Exception {
		String cid=request.getParameter("cid");
		String cname=request.getParameter("cname");
		String cpwd=request.getParameter("cpwd");
		String crealname=request.getParameter("crealname");
		String cphone=request.getParameter("cphone");
		String status=request.getParameter("status");
		String address=request.getParameter("address");
		String urlNameString = "http://pangyan-123.gnway.cc/DongMaven/t_CUSTUMER/update?cid="+cid+"&cname="+cname+"&cpwd="+cpwd+"&crealname="+crealname+"&cphone="+cphone+"&status="+status+"&address="+address+"";
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
	public void add() throws Exception {
		String cname=request.getParameter("cname");
		String cpwd=request.getParameter("cpwd");
		String crealname=request.getParameter("crealname");
		String cphone=request.getParameter("cphone");
		String status=request.getParameter("status");
		String address=request.getParameter("address");
		String urlNameString = "http://pangyan-123.gnway.cc/DongMaven/t_CUSTUMER/save?cname="+cname+"&cpwd="+cpwd+"&crealname="+crealname+"&cphone="+cphone+"&status="+status+"&address="+address+"";
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
	public void del() throws Exception {
		String cid=request.getParameter("cid");
		String urlNameString = "http://pangyan-123.gnway.cc/DongMaven/t_CUSTUMER/del?cid="+cid+"";
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
