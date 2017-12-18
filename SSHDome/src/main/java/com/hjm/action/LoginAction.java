package com.hjm.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Scope("prototype")
public class LoginAction extends GonggoAction{
	
	String cname=request.getParameter("cname");
	String cpwd=request.getParameter("cpwd");
	String crealname=request.getParameter("crealname");
	String cphone=request.getParameter("cphone");
	String address=request.getParameter("address");
	String Code=request.getParameter("code");
	
	public void duanxin() {
		sendsms s = new sendsms();
		String telephone = request.getParameter("cphone");
		s.duanxin(telephone);
	}
	
	public void login() throws Exception{
		System.out.println("dskjdk");
		session.setAttribute("username", cname);
		System.out.println("11111111111");
	String urlNameString="http://pangyan-123.gnway.cc/DongMaven/t_CUSTUMER/login?cname=custumer.cname&cpwd=custumer.cpwd";
	urlNameString=urlNameString.replace("custumer.cname",cname);
	urlNameString=urlNameString.replace("custumer.cpwd",cpwd);
	String result="";
	try {
		//���ݵ�ַ��ȡ����
		HttpGet request=new HttpGet(urlNameString);
		//��ȡ��ǰ�ͻ��˶���
		HttpClient client= HttpClientBuilder.create().build();
		//ͨ����������ȡ��Ӧ����
		HttpResponse response=client.execute(request);
		//�ж���������״̬���Ƿ�����
		if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
			result=EntityUtils.toString(response.getEntity(),"utf-8");
		}
		JSONArray jsonArray = JSONArray.fromObject(result);
		JSONObject jsonobject = (JSONObject) jsonArray.get(0);
		Map map=jsonobject;
		session.setAttribute("user", map);
		
		String phone = jsonobject.getString("cphone");
		System.out.println(phone);
		session.setAttribute("phone", phone);
		System.out.println("����action");
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}

	response.setCharacterEncoding("utf-8");
	System.out.println("result------------------------"+result);
	response.getWriter().write(result);
	
	}
	//ע��
	public void zhuce() throws Exception{
		System.out.println("ע��");
	String urlNameString="http://pangyan-123.gnway.cc/DongMaven/t_CUSTUMER/save?cname=custumer.cname&cpwd=custumer.cpwd&crealname=custumer.crealname&cphone=custumer.cphone&address=custumer.address";
	urlNameString=urlNameString.replace("custumer.cname",cname);
	urlNameString=urlNameString.replace("custumer.cpwd",cpwd);
	urlNameString=urlNameString.replace("custumer.crealname",crealname);
	urlNameString=urlNameString.replace("custumer.cphone",cphone);
	urlNameString=urlNameString.replace("custumer.address",address);
	String mobile_code = (String) session.getAttribute("mobile_code").toString();
	String code = Code;
	if(!code.equals(mobile_code)) {
		System.out.println("��֤�벻��ȷ");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("��֤�벻��ȷ��");
	}else{
	String result="";
	try {
		//���ݵ�ַ��ȡ����
		HttpGet request=new HttpGet(urlNameString);
		//��ȡ��ǰ�ͻ��˶���
		HttpClient client= HttpClientBuilder.create().build();
		//ͨ����������ȡ��Ӧ����
		HttpResponse response=client.execute(request);
		//�ж���������״̬���Ƿ�����
		if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
			result=EntityUtils.toString(response.getEntity(),"utf-8");
		}
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	response.setCharacterEncoding("utf-8");
	System.out.println("result------------------------"+result);
	response.getWriter().write(result);
	}
	}
	
	/**
	 * ���session�˳���¼
	 * @param request
	 */
	public String zhuxiao() {
		session.removeAttribute("user");
		return "zhuye";
	}	
	public String kong(HttpServletRequest request) {
		Enumeration em = request.getSession().getAttributeNames();
		  while(em.hasMoreElements()){
		   request.getSession().removeAttribute(em.nextElement().toString());
		  }
		  return "denglu";
	}
	
	public List list ;
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	public String deng() {
		return "login";
	}
	
	public String shouye() {
		return "zhuye";
	}
	public String bingxiang() {
		return "bingxiang";
	}
	public String dianshi() {
		return "dianshi";
	}
	public String diannao() {
		return "diannao";
	}
	public String gouwuche() {
		System.out.println(111);
		return "gouwuche";

	}
	
	
	
}
