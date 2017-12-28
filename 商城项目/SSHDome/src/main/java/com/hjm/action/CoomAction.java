package com.hjm.action;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CoomAction extends GonggoAction{
	
	//查询商品
		public void all() throws Exception{
			System.out.println("查询商品");
		String urlNameString="http://127.0.0.1:8080/DongMaven/commodity/all";
		String result="";
		try {
			//根据地址获取请求
			HttpGet request=new HttpGet(urlNameString);
			//获取当前客户端对象
			HttpClient client= HttpClientBuilder.create().build();
			//通过请求对象获取响应对象
			HttpResponse response=client.execute(request);
			//判断网络连接状态码是否正常
			if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
				result=EntityUtils.toString(response.getEntity(),"utf-8");
			}
			System.out.println("返回action");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		
		}	
		//根据id
		public void allid() throws Exception{
			System.out.println("查询id");
			request.getParameter("id");
		String urlNameString="http://127.0.0.1:8080/DongMaven/commodity/oneselect?cid=id";
		String result="";
		try {
			//根据地址获取请求
			HttpGet request=new HttpGet(urlNameString);
			//获取当前客户端对象
			HttpClient client= HttpClientBuilder.create().build();
			//通过请求对象获取响应对象
			HttpResponse response=client.execute(request);
			//判断网络连接状态码是否正常
			if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
				result=EntityUtils.toString(response.getEntity(),"utf-8");
			}
			System.out.println("返回action");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		
		}	
		//添加购物车
				public String add() throws Exception{
				System.out.println("添加购物车");
				String cid=request.getParameter("cid");
				 session = request.getSession();
				String cname = (String) session.getAttribute("username");
				System.out.println(cname);
				String urlNameString="http://127.0.0.1:8080/DongMaven/shop/save?cid=shop.cid&cname=c.cname";
				urlNameString=urlNameString.replace("shop.cid",cid);
				urlNameString=urlNameString.replace("c.cname",cname);
				String result="";
				try {
					//根据地址获取请求
					HttpGet request=new HttpGet(urlNameString);
					//获取当前客户端对象
					HttpClient client= HttpClientBuilder.create().build();
					//通过请求对象获取响应对象
					HttpResponse response=client.execute(request);
					//判断网络连接状态码是否正常
					if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
						result=EntityUtils.toString(response.getEntity(),"utf-8");
					}
					System.out.println("返回action");
					
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					
				}
				return "zhuye";
				}
				
				
				public String tiao() {
					return "zhuye";
				}
				public String dd() {
					return "dingdan";
				}
				public String gouwuche() {
					return "gouwuche";
				}
		
		//查询购物车
			public void sall() throws Exception{
					System.out.println("查询购物车");
					 session = request.getSession();
						String cname = (String) session.getAttribute("username");
				String urlNameString="http://127.0.0.1:8080/DongMaven/shop/nameall?cname=c.cname";
				urlNameString=urlNameString.replace("c.cname",cname);
				
				String result="";
				try {
					//根据地址获取请求
					HttpGet request=new HttpGet(urlNameString);
					//获取当前客户端对象
					HttpClient client= HttpClientBuilder.create().build();
					//通过请求对象获取响应对象
					HttpResponse response=client.execute(request);
					//判断网络连接状态码是否正常
					if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
						result=EntityUtils.toString(response.getEntity(),"utf-8");
					}
					System.out.println("返回action");
					
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(result);
				}	
			
			
			//删除商品
			public String del() throws Exception{
				System.out.println("删除");
			String shid=request.getParameter("shid");
			String urlNameString="http://127.0.0.1:8080/DongMaven/shop/del?shid=shop.shid";
			urlNameString=urlNameString.replace("shop.shid",shid);
			String result="";
			try {
				//根据地址获取请求	
				HttpGet request=new HttpGet(urlNameString);
				//获取当前客户端对象
				HttpClient client= HttpClientBuilder.create().build();
				//通过请求对象获取响应对象
				HttpResponse response=client.execute(request);
				//判断网络连接状态码是否正常
				if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
					result=EntityUtils.toString(response.getEntity(),"utf-8");
				}
				System.out.println("返回action");
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(result);
			return "gouwuche";
			}

			//删除用户所有商品
			public String delall() throws Exception{
				System.out.println("删除");
				 session = request.getSession();
					String cname = (String) session.getAttribute("username");
			String urlNameString="http://127.0.0.1:8080/DongMaven/shop/onealldelect?cname=shop.cname";
			urlNameString=urlNameString.replace("shop.cname",cname);
			String result="";
			try {
				//根据地址获取请求	
				HttpGet request=new HttpGet(urlNameString);
				//获取当前客户端对象
				HttpClient client= HttpClientBuilder.create().build();
				//通过请求对象获取响应对象
				HttpResponse response=client.execute(request);
				//判断网络连接状态码是否正常
				if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
					result=EntityUtils.toString(response.getEntity(),"utf-8");
				}
				System.out.println("返回action");
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("result:"+result);
			return "gouwuche";
			}
			
			//提交购物车
			public String tijiao() throws Exception{
			System.out.println("提交购物车");
			String shid=request.getParameter("shid");
			System.out.println("shid:"+shid);
			session = request.getSession();
			String cname=(String) session.getAttribute("username");
			String cphone=(String) session.getAttribute("phone");
				System.out.println("cname:"+cname);
				System.out.println("phone:"+cphone);
			String urlNameString="http://127.0.0.1:8080/DongMaven/commOrder/save?shid=shop.shid&cname=c.cname&cphone=p.phone";
			urlNameString=urlNameString.replace("shop.shid",shid);
			urlNameString=urlNameString.replace("c.cname",cname);
			urlNameString=urlNameString.replace("p.phone",cphone);
			String result="";
			try {
				//根据地址获取请求
				HttpGet request=new HttpGet(urlNameString);
				//获取当前客户端对象
				HttpClient client= HttpClientBuilder.create().build();
				//通过请求对象获取响应对象
				HttpResponse response=client.execute(request);
				//判断网络连接状态码是否正常
				if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
					result=EntityUtils.toString(response.getEntity(),"utf-8");
				}
				 delall();
				System.out.println("返回action");
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
			
			 return"gouwuche";
			}
			//查询订单
			public void dingdan() throws Exception{
					System.out.println("查询订单");
					 session = request.getSession();
						String cname = (String) session.getAttribute("username");
				String urlNameString="http://127.0.0.1:8080/DongMaven/commOrder/nameall?cname=c.cname";
				urlNameString=urlNameString.replace("c.cname",cname);
				
				String result="";
				try {
					//根据地址获取请求
					HttpGet request=new HttpGet(urlNameString);
					//获取当前客户端对象
					HttpClient client= HttpClientBuilder.create().build();
					//通过请求对象获取响应对象
					HttpResponse response=client.execute(request);
					//判断网络连接状态码是否正常
					if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
						result=EntityUtils.toString(response.getEntity(),"utf-8");
					}
					System.out.println("返回action");
					
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(result);
				
				}	
			
		
}
