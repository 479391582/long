package com.Menu.action;

import java.util.HashMap;
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
import com.google.gson.JsonArray;
import com.houtai.Common.action.CommonAction;

/** 
* @ClassName: Menu 
* @Description: TODO(T_Menu �˵���) 
* @author Huang Ti Long 
* @date 2017��12��4�� ����10:10:03 
*  
*/
@Controller
@Scope("prototype")
public class Menu extends CommonAction{
	
	public 	String t_user() {
		return "t_user";
	}
	public String getall() throws Exception {
		HttpSession session = request.getSession();
		map=(Map) session.getAttribute("user");
		String usid=(String) map.get("usid");
		System.out.println("usid:"+usid);
		String urlNameString = "http://127.0.0.1:8080/DongMaven/t_user/shu?usid="+usid+"";
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
		System.out.println(jsonArray.toString());
		return jsonArray.toString();
	}
	//��ת��־
	public String tzrizhi() {
		return "rizhi";
	}
	public void getrizhiall() throws Exception {
		String urlNameString = "http://127.0.0.1:8080/DongMaven/t_MENU/rizhi";
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
		Map map=new HashMap();
		map.put("code", 0);
		map.put("msg", 0);
		map.put("count", jsonArray.size());
		map.put("data", jsonArray);
		String jsonObject=JSONObject.toJSONString(map);
		response.getWriter().write(jsonObject.toString());
	}
}
