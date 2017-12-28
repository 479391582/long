package com.pro.dong.T_CUSTUMER.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.pro.dong.T_CUSTUMER.entity.T_CUSTUMER;
import com.pro.dong.T_CUSTUMER.entity.T_ROLE_CUSTUMER;
import com.pro.dong.T_CUSTUMER.service.T_CUSTUMERService;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


//�ͻ���
@Controller
@RequestMapping("/t_CUSTUMER")
public class T_CUSTUMERController{
	       @Autowired
			private T_CUSTUMERService t_CUSTUMERService;
			
	   	/**
			 * ��¼
			 * @return
			 */
			@RequestMapping(value="/login",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public String login(String cname,String cpwd) {
				System.out.println("�����¼");
				 HashMap<String, Object> map = new HashMap<String, Object>();
			      map.put("cname",cname);
			      map.put("cpwd",cpwd);
			      String t_CUSTUMERs= t_CUSTUMERService.getUserByUsernameAndPassword(map).toString();
			       System.out.println("t_CUSTUMERs:"+t_CUSTUMERs.length());
			       if(t_CUSTUMERs.length()>2) {
			    	   List list  = t_CUSTUMERService.nameall(cname);
			    	   System.out.println("list:"+list);
	                 	JSONArray jsonArray= JSONArray.fromObject(list);
	                 	System.out.println("jsonArray:"+jsonArray);
	                 	 System.out.println("��ȷ");
				    	   return jsonArray.toString();
			}
			       System.out.println("����");
			       return "error";
	       
			}
	       
	       
	       
			/**
			 * ��ѯȫ��
			 * @param response
			 * @throws IOException
			 */
			@RequestMapping(value="/all",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public String all() throws IOException {
				Object object= t_CUSTUMERService.all();
				 JSONArray  jsonArray= JSONArray .fromObject(object);
				System.out.println("JSONARRAY:"+jsonArray.toString());
			    return jsonArray.toString();
			}
			
			/**
			 * �ж��û��Ƿ����
			 * @return
			 */
			@RequestMapping(value="/saveof",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
	       public String saveof(String cname) {
				String str =t_CUSTUMERService.nameall(cname).toString();
				System.out.println("str:"+str.length());
				//�ж��û��Ƿ����
				if(str.length() <=2) {
					System.out.println("�û������ڣ�");
					return "error";
				}
				System.out.println("�û����ڣ�");
				return "success";
	       }
			
			
			
			
			
			/**
			 * ע�����
			 * @return
			 * @throws UnsupportedEncodingException 
			 */
			@RequestMapping(value="/save",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public String save(HttpServletRequest request) throws UnsupportedEncodingException {
				System.out.println("����ע��");
				//ʹ������ռ�����
				request.setCharacterEncoding("UTF-8");
				String cname=request.getParameter("cname");
				String str =t_CUSTUMERService.nameall(cname).toString();
				System.out.println("str:"+str.length());
				//�ж��û��Ƿ����
				if(str.length() <=2) {
					String cpwd =request.getParameter("cpwd");
					String crealname = request.getParameter("crealname");
					String cphone = request.getParameter("cphone");
					String address = request.getParameter("address");
					T_CUSTUMER t_CUSTUMER=new T_CUSTUMER();
					t_CUSTUMER.setCname(cname);
					t_CUSTUMER.setCpwd(cpwd);
					t_CUSTUMER.setCrealname(crealname);
					t_CUSTUMER.setCphone(cphone);
					t_CUSTUMER.setAddress(address);
					t_CUSTUMERService.save(t_CUSTUMER);
					System.out.println("t_CUSTUMER:"+t_CUSTUMER);
					return "success";
				}
				return "error";
			}
			
			/**
			 * ɾ��
			 * @return
			 */
			@RequestMapping("/del")
			@ResponseBody
			public String del(String cid) {
				System.out.println("userɾ����");
				t_CUSTUMERService.del(cid);
				return "success";
			}
			
			/**
			 * �޸�
			 * @return
			 * @throws UnsupportedEncodingException 
			 */
			@RequestMapping("/update")
			@ResponseBody
			public String update(T_CUSTUMER t_CUSTUMER) throws UnsupportedEncodingException {
//				request.setCharacterEncoding("UTF-8");
				t_CUSTUMERService.upd(t_CUSTUMER);
				return "success";
			}
			
			/**
			 * ����id��ѯ
			 * @return
			 * @throws IOException 
			 */
			@RequestMapping(value="/oneselect",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public String oneselect(String cid) throws IOException {
				List  list = t_CUSTUMERService.oneall(cid);
		        System.out.println("list:"+list);
		        JSONArray  jsonArray= JSONArray .fromObject(list);
		        return jsonArray.toString();
			}
			
			
			
		
			
			/**
			 * ����Ȩ��
			 * @return
			 */
			@RequestMapping(value="/keyall",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
 			public String keyall(String cid,String rid) {
				T_ROLE_CUSTUMER t_ROLE_CUSTUMER=new T_ROLE_CUSTUMER();
				t_ROLE_CUSTUMER.setCid(cid);
				t_ROLE_CUSTUMER.setRid(rid);
			    t_CUSTUMERService.mansave(t_ROLE_CUSTUMER);
				return "success";
 			}
		
			
			/**
			 * �˵�
			 * @throws IOException 
			 */
			@RequestMapping(value="/shu",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public String shu( String cid) throws IOException {
				System.out.println("�˵�");
	               List list =t_CUSTUMERService.rolemunelist(cid);
    				System.out.println("go kkkkkk");
    				System.out.println("�˵�list:"+list);
    				JSONArray jsonArray= JSONArray.fromObject(list);
     				System.out.println("jsonArray��"+jsonArray.toString());
     				return jsonArray.toString();

			}
			
			
			
			/**
			 * ��ҳ
			 */
				@RequestMapping(value="/page",method=RequestMethod.GET,produces="text/html;charset=utf-8")
				@ResponseBody
	 			public String  page(@RequestParam(value="currentPage",defaultValue="0",required=false)int currentPage,Model model) {
					model.addAttribute("pagemsg", t_CUSTUMERService.findByPage(currentPage));//���Է�ҳ����
					JSONArray jsonArray= JSONArray.fromObject(model);
					  return jsonArray.toString();
				}
 			
				/**
				 * ͨ���ֻ��ŵ�¼
				 */
					@RequestMapping(value="/copen",method=RequestMethod.GET,produces="text/html;charset=utf-8")
					@ResponseBody
		public String copen(String cphone) {
			List list=t_CUSTUMERService.openoneall(cphone);
			System.out.println("list:"+list.size());
			if(list.size()==0) {
				return "error";
			}
			JSONArray jsonArray= JSONArray.fromObject(list);
			return jsonArray.toString();
		}
			
}
