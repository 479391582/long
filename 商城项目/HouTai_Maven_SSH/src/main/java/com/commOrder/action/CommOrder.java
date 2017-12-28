package com.commOrder.action;

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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.houtai.Common.action.CommonAction;

/** 
* @ClassName: CommOrder 
* @Description: TODO(������һ�仰��������������) 
* @author Huang Ti Long 
* @date 2017��12��4�� ����10:07:22 
*  
*/
@Controller
@Scope("prototype")
public class CommOrder extends CommonAction{
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
		String coid=request.getParameter("coid");
		String urlNameString = "http://127.0.0.1:8080/DongMaven/commOrder/oneselect?coid="+coid+"";
		String result="";
		try {
			// ���ݵ�ַ��ȡ����
			HttpGet request = new HttpGet(urlNameString);//���﷢��get����
			// ��ȡ��ǰ�ͻ��˶���
			HttpClient client = HttpClientBuilder.create().build();
			// ͨ����������ȡ��Ӧ����
			HttpResponse response = client.execute(request);
			// �ж���������״̬���Ƿ�����(0--200��������)
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
		if(status.equals("δ�ɹ�")) {
			status="�����ɹ�";
		}else if (status.equals("�����ɹ�")) {
			status="���깤";
		}
		urlNameString = "http://127.0.0.1:8080/DongMaven/commOrder/update?coid="+coid+"&status="+status+"";
		result="";
		try {
			// ���ݵ�ַ��ȡ����
			HttpGet request = new HttpGet(urlNameString);//���﷢��get����
			// ��ȡ��ǰ�ͻ��˶���
			HttpClient client = HttpClientBuilder.create().build();
			// ͨ����������ȡ��Ӧ����
			HttpResponse response = client.execute(request);
			// �ж���������״̬���Ƿ�����(0--200��������)
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
		urlNameString = "http://127.0.0.1:8080/DongMaven/commOrder/page";
		}else {
			urlNameString = "http://127.0.0.1:8080/DongMaven/commOrder/page?currentPage="+totalPage+"";
		}
		String result="";
		try {
			// ���ݵ�ַ��ȡ����
			HttpGet request = new HttpGet(urlNameString);//���﷢��get����
			// ��ȡ��ǰ�ͻ��˶���
			HttpClient client = HttpClientBuilder.create().build();
			// ͨ����������ȡ��Ӧ����
			HttpResponse response = client.execute(request);
			// �ж���������״̬���Ƿ�����(0--200��������)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result= EntityUtils.toString(response.getEntity(),"utf-8");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray=JSONArray.parseArray(result);
		JSONObject ob  = (JSONObject) jsonArray.get(0);//�õ�json����
		String  pagemsg= ob.getString("pagemsg");
		JSONObject jsonObject=JSONObject.parseObject(pagemsg);
		currPage= jsonObject.getString("currPage");
		session.setAttribute("totalPage", currPage);
		totalPage= jsonObject.getString("totalPage");
		session.setAttribute("CommOrder", totalPage);
		System.out.println("CommOrdertotalPage:"+totalPage);
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
		String coid=request.getParameter("coid");
		String urlNameString = "http://127.0.0.1:8080/DongMaven/commOrder/oneselect?coid="+coid+"";
		String result="";
		try {
			// ���ݵ�ַ��ȡ����
			HttpGet request = new HttpGet(urlNameString);//���﷢��get����
			// ��ȡ��ǰ�ͻ��˶���
			HttpClient client = HttpClientBuilder.create().build();
			// ͨ����������ȡ��Ӧ����
			HttpResponse response = client.execute(request);
			// �ж���������״̬���Ƿ�����(0--200��������)
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
		String coid=request.getParameter("coid");
		String coname=request.getParameter("coname");
		String coprice=request.getParameter("coprice");
		String cotype=request.getParameter("cotype");
		String cobrand=request.getParameter("cobrand");
		String status=request.getParameter("status");
		String cname=request.getParameter("cname");
		String cphone=request.getParameter("cphone");
		String urlNameString = "http://127.0.0.1:8080/DongMaven/commOrder/update?coname="+coname+"&coprice="+coprice+"&cotype="+cotype+"&cobrand="+cobrand+"&status="+status+"&cname="+cname+"&cphone="+cphone+"&coid="+coid+"";
		String result="";
		try {
			// ���ݵ�ַ��ȡ����
			HttpGet request = new HttpGet(urlNameString);//���﷢��get����
			// ��ȡ��ǰ�ͻ��˶���
			HttpClient client = HttpClientBuilder.create().build();
			// ͨ����������ȡ��Ӧ����
			HttpResponse response = client.execute(request);
			// �ж���������״̬���Ƿ�����(0--200��������)
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
		String coname=request.getParameter("coname");
		String coprice=request.getParameter("coprice");
		String cotype=request.getParameter("cotype");
		String cobrand=request.getParameter("cobrand");
		String status=request.getParameter("status");
		String cname=request.getParameter("cname");
		String cphone=request.getParameter("cphone");
		String urlNameString = "http://127.0.0.1:8080/DongMaven/commOrder/save?coname="+coname+"&coprice="+coprice+"&cotype="+cotype+"&cobrand="+cobrand+"&status="+status+"&cname="+cname+"&cphone="+cphone+"";
		String result="";
		try {
			// ���ݵ�ַ��ȡ����
			HttpGet request = new HttpGet(urlNameString);//���﷢��get����
			// ��ȡ��ǰ�ͻ��˶���
			HttpClient client = HttpClientBuilder.create().build();
			// ͨ����������ȡ��Ӧ����
			HttpResponse response = client.execute(request);
			// �ж���������״̬���Ƿ�����(0--200��������)
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
	public String tzditu() throws IOException {
		String cid=request.getParameter("weizhi");
		String urlNameString = "http://127.0.0.1:8080/DongMaven/t_CUSTUMER/oneselect?cid="+weizhi+"";
		String result="";
		try {
			// ���ݵ�ַ��ȡ����
			HttpGet request = new HttpGet(urlNameString);//���﷢��get����
			// ��ȡ��ǰ�ͻ��˶���
			HttpClient client = HttpClientBuilder.create().build();
			// ͨ����������ȡ��Ӧ����
			HttpResponse response = client.execute(request);
			// �ж���������״̬���Ƿ�����(0--200��������)
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
		weizhi=jsonObject.getString("address");
		return "tzditu";
	}
	public void del() throws Exception {
		String coid=request.getParameter("coid");
		String urlNameString = "http://127.0.0.1:8080/DongMaven/commOrder/del?coid="+coid+"";
		String result="";
		try {
			// ���ݵ�ַ��ȡ����
			HttpGet request = new HttpGet(urlNameString);//���﷢��get����
			// ��ȡ��ǰ�ͻ��˶���
			HttpClient client = HttpClientBuilder.create().build();
			// ͨ����������ȡ��Ӧ����
			HttpResponse response = client.execute(request);
			// �ж���������״̬���Ƿ�����(0--200��������)
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
