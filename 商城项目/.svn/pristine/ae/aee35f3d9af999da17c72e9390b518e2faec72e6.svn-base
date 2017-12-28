package com.Login.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.Common.action.CommonInformaAction;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * @author 47939
 *
 */
@Controller
@Scope("prototype")
public class LoginAction extends CommonInformaAction{
	
	public String tzgetll() {
		return "success";
	}
	/**
	 * 登陆
	 * @return
	 */
	public void login() throws Exception{
	String urlNameString="http://pangyan-123.gnway.cc/DongMaven/t_CUSTUMER/login?cname=custumer.cname&cpwd=custumer.cpwd";
	urlNameString=urlNameString.replace("custumer.cname", custumer.getCname());
	urlNameString=urlNameString.replace("custumer.cpwd", custumer.getCpwd());
	System.out.println("mingzi:"+custumer.getCpwd());
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
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray=JSONArray.parseArray(result);
		JSONObject jsonObject=(JSONObject) jsonArray.get(0);
		Map map=jsonObject;
		if(jsonArray.size()==0) {
			result="error";
		}
		result="success";
		HttpSession session=request.getSession();
		
		
		session.setAttribute("user", map);
		response.getWriter().write(result);
	}
	
	
	
	
	public void save() throws Exception{
		String rtype = request.getParameter("rtype"); 
		String rbrand = request.getParameter("rbrand"); 
		String fault = request.getParameter("fault");
		String remarks=request.getParameter("remarks");
		
		HttpSession session=request.getSession();
		Map map=(Map) session.getAttribute("user");
		String cid=map.get("cid").toString();
		String cname=map.get("cname").toString();
		String cphone=map.get("cphone").toString();
		String url="http://pangyan-123.gnway.cc/DongMaven/repairOrder/save?rtype=repairOrder.rtype&rbrand=repairOrder.rbrand&fault=repairOrder.fault&remarks=repairOrder.remarks&cname=repairOrder.cname&cphone=repairOrder.cphone";
		url=url.replace("repairOrder.rbrand", rbrand);
		url=url.replace("repairOrder.fault",  fault);
		url=url.replace("repairOrder.rtype", rtype);
		url=url.replace("repairOrder.remarks", remarks);
		url=url.replace("repairOrder.cname", cname);
		url=url.replace("repairOrder.cphone", cphone);
		String result="";
		try {
			//根据地址获取请求						
			HttpGet request=new HttpGet(url);
			//获取当前客户端对象
			HttpClient client= HttpClientBuilder.create().build();
			//通过请求对象获取响应对象
			HttpResponse response=client.execute(request);
			//判断网络连接状态码是否正常
			if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
				result=EntityUtils.toString(response.getEntity(),"utf-8");
			}

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		String sheng = request.getParameter("sheng"); 
		String shi = request.getParameter("shi"); 
		String xian = request.getParameter("xian"); 
		String jie = request.getParameter("jie"); 
		String address = sheng+shi+xian+jie;
		
		url="http://pangyan-123.gnway.cc/DongMaven/t_CUSTUMER/update?cid="+cid+"&address="+address+"";
		result="";
		try {
			//根据地址获取请求						
			HttpGet request=new HttpGet(url);
			//获取当前客户端对象
			HttpClient client= HttpClientBuilder.create().build();
			//通过请求对象获取响应对象
			HttpResponse response=client.execute(request);
			//判断网络连接状态码是否正常
			if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
				result=EntityUtils.toString(response.getEntity(),"utf-8");
			}

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(result);
	}
	
	
	
	

}
