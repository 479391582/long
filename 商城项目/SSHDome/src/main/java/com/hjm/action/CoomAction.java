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
	
	//��ѯ��Ʒ
		public void all() throws Exception{
			System.out.println("��ѯ��Ʒ");
		String urlNameString="http://127.0.0.1:8080/DongMaven/commodity/all";
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
			System.out.println("����action");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		
		}	
		//����id
		public void allid() throws Exception{
			System.out.println("��ѯid");
			request.getParameter("id");
		String urlNameString="http://127.0.0.1:8080/DongMaven/commodity/oneselect?cid=id";
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
			System.out.println("����action");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		
		}	
		//��ӹ��ﳵ
				public String add() throws Exception{
				System.out.println("��ӹ��ﳵ");
				String cid=request.getParameter("cid");
				 session = request.getSession();
				String cname = (String) session.getAttribute("username");
				System.out.println(cname);
				String urlNameString="http://127.0.0.1:8080/DongMaven/shop/save?cid=shop.cid&cname=c.cname";
				urlNameString=urlNameString.replace("shop.cid",cid);
				urlNameString=urlNameString.replace("c.cname",cname);
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
					System.out.println("����action");
					
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
		
		//��ѯ���ﳵ
			public void sall() throws Exception{
					System.out.println("��ѯ���ﳵ");
					 session = request.getSession();
						String cname = (String) session.getAttribute("username");
				String urlNameString="http://127.0.0.1:8080/DongMaven/shop/nameall?cname=c.cname";
				urlNameString=urlNameString.replace("c.cname",cname);
				
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
					System.out.println("����action");
					
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(result);
				}	
			
			
			//ɾ����Ʒ
			public String del() throws Exception{
				System.out.println("ɾ��");
			String shid=request.getParameter("shid");
			String urlNameString="http://127.0.0.1:8080/DongMaven/shop/del?shid=shop.shid";
			urlNameString=urlNameString.replace("shop.shid",shid);
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
				System.out.println("����action");
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(result);
			return "gouwuche";
			}

			//ɾ���û�������Ʒ
			public String delall() throws Exception{
				System.out.println("ɾ��");
				 session = request.getSession();
					String cname = (String) session.getAttribute("username");
			String urlNameString="http://127.0.0.1:8080/DongMaven/shop/onealldelect?cname=shop.cname";
			urlNameString=urlNameString.replace("shop.cname",cname);
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
				System.out.println("����action");
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("result:"+result);
			return "gouwuche";
			}
			
			//�ύ���ﳵ
			public String tijiao() throws Exception{
			System.out.println("�ύ���ﳵ");
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
				 delall();
				System.out.println("����action");
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
			
			 return"gouwuche";
			}
			//��ѯ����
			public void dingdan() throws Exception{
					System.out.println("��ѯ����");
					 session = request.getSession();
						String cname = (String) session.getAttribute("username");
				String urlNameString="http://127.0.0.1:8080/DongMaven/commOrder/nameall?cname=c.cname";
				urlNameString=urlNameString.replace("c.cname",cname);
				
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
					System.out.println("����action");
					
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(result);
				
				}	
			
		
}
