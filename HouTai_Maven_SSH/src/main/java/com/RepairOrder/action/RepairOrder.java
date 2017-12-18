package com.RepairOrder.action;

import java.io.IOException;
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

import com.sendsms;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.houtai.Common.action.CommonAction;

/** 
* @ClassName: CommOrder 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Huang Ti Long 
* @date 2017年12月4日 上午10:07:22 
*  
*/
@Controller
@Scope("prototype")
public class RepairOrder extends CommonAction{
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
	
	public void caozuo() throws IOException {
		String reid=request.getParameter("reid");
		String urlNameString = "http://pangyan-123.gnway.cc/DongMaven/repairOrder/oneselect?reid="+reid+"";
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
		String status=(String) map.get("status");
		if(status.equals("未派工")) {
			status="正在派工";
			sendsms s = new sendsms();
			HttpSession session = request.getSession();
			Map zhiwu=(Map)session.getAttribute("zhiwu");
			String  name=(String) zhiwu.get("UNAME");
			String  phone=(String) zhiwu.get("UPHONE");
			String  cname=(String) map.get("cname");
			String  cphone=(String) map.get("cphone");
			s.duanxin(cname, cphone, name, phone);
		}else if (status.equals("正在派工")) {
			status="已完工";
		}
		urlNameString = "http://pangyan-123.gnway.cc/DongMaven/repairOrder/update?reid="+reid+"&status="+status+"";
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
	
	public String getall() throws Exception {
		HttpSession session = request.getSession();
		String totalPage=(String) session.getAttribute("totalPage");
		String urlNameString=null;
		if (totalPage==null) {
			urlNameString = "http://pangyan-123.gnway.cc/DongMaven/repairOrder/page";
		}else {
			urlNameString = "http://pangyan-123.gnway.cc/DongMaven/repairOrder/page?currentPage="+totalPage+"";
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
		totalPage= jsonObject.getString("totalPage");
		session.setAttribute("RepairOrder", totalPage);
		System.out.println("RepairOrdertotalPage:"+totalPage);
		currPage= jsonObject.getString("currPage");
		session.setAttribute("totalPage", currPage);
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
		String reid=request.getParameter("reid");
		String urlNameString = "http://pangyan-123.gnway.cc/DongMaven/repairOrder/oneselect?reid="+reid+"";
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
		String reid=request.getParameter("reid");
		String rtype=request.getParameter("rtype");
		String rbrand=request.getParameter("rbrand");
		String fault=request.getParameter("fault");
		String remarks=request.getParameter("remarks");
		String status=request.getParameter("status");
		String cname=request.getParameter("cname");
		String cphone=request.getParameter("cphone");
		String urlNameString = "http://pangyan-123.gnway.cc/DongMaven/repairOrder/update?rtype="+rtype+"&rbrand="+rbrand+"&fault="+fault+"&remarks="+remarks+"&status="+status+"&cname="+cname+"&cphone="+cphone+"&reid="+reid+"";
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
		String rtype=request.getParameter("rtype");
		String rbrand=request.getParameter("rbrand");
		String fault=request.getParameter("fault");
		String remarks=request.getParameter("remarks");
		String status=request.getParameter("status");
		String cname=request.getParameter("cname");
		String cphone=request.getParameter("cphone");
		String urlNameString = "http://pangyan-123.gnway.cc/DongMaven/repairOrder/save?rtype="+rtype+"&rbrand="+rbrand+"&fault="+fault+"&remarks="+remarks+"&status="+status+"&cname="+cname+"&cphone="+cphone+"";
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
		String reid=request.getParameter("reid");
		String urlNameString = "http://pangyan-123.gnway.cc/DongMaven/repairOrder/del?reid="+reid+"";
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
