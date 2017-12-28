package com.pro.dong.T_user.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.dong.T_CUSTUMER.entity.T_CUSTUMER;
import com.pro.dong.T_CUSTUMER.entity.T_ROLE_CUSTUMER;
import com.pro.dong.T_ROLE.entity.T_USER_ROLE;
import com.pro.dong.T_user.entity.T_user;
import com.pro.dong.T_user.service.T_userService;
import com.pro.dong.commodity.entity.Commodity;
import com.pro.dong.commodity.service.CommodityService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


//Ա����
@Controller
@RequestMapping("/t_user")
public class T_userController {
	@Autowired
	private T_userService t_userService;

	/**
	 * ��¼
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request) {
		System.out.println("�����¼");
		//���ܲ���
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("uname",uname);
		map.put("upwd",upwd);
		String t_CUSTUMERs= t_userService.getUserByUsernameAndPassword(map).toString();
		if(t_CUSTUMERs.length()>2) {
			List list  = t_userService.nameall(uname);
			System.out.println("list:"+list);
			JSONArray jsonArray= JSONArray.fromObject(list);
			System.out.println("jsonArray:"+jsonArray);
			HttpSession session=request.getSession();
			session.setAttribute("user", jsonArray.toString());
			MDC.put("userName",uname);
			MDC.put("userpwd",upwd);
			return jsonArray.toString();
		}
		return "error";

	}

	/**
	 * �ж��û��Ƿ����
	 * @return
	 */
	@RequestMapping(value="/saveof",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String saveof(HttpServletRequest request) {
		String uname = request.getParameter("uname");
		String str =t_userService.nameall(uname).toString();
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
		//	String uname = request.getParameter("uname");
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");
		String str =t_userService.nameall(uname).toString();
		System.out.println("str:"+str.length());
		//�ж��û��Ƿ����
		if(str.length() <=2) {
			String upwd = request.getParameter("upwd");
			String urealname = request.getParameter("urealname");
			String uphone = request.getParameter("uphone");
			T_user t_user=new T_user();
			t_user.setUname(uname);
			t_user.setUpwd(upwd);
			t_user.setUrealname(urealname);
			t_user.setUphone(uphone);
			t_userService.save(t_user);
			System.out.println("t_user:"+t_user);
			return "success";
		}
		return "error";
	}



	/**
	 * ��ѯȫ��
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/all",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String all(HttpServletResponse response) throws IOException {
		Object object= t_userService.all();
		JSONArray jsonArray= JSONArray.fromObject(object);
		System.out.println("JSONARRAY:"+jsonArray.toString());
		return jsonArray.toString();

	}



	/**
	 * ɾ��
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String del(String usid) {
		System.out.println("userɾ����");
		t_userService.del(usid);
		return "success";
	}

	/**
	 * �޸�
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/update",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String update(T_user t_user,HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		t_userService.upd(t_user);
		return "success";
	}

	/**
	 * ����id��ѯ
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/oneselect",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public void oneselect(String usid,HttpServletResponse response) throws IOException {
		List  list = t_userService.oneall(usid);
		System.out.println("list:"+list);
		JSONArray  jsonArray= JSONArray .fromObject(list);
		System.out.println("JSONARRAY:"+jsonArray.toString());
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonArray.toString());

	}

	/**
	 * ��ҳ
	 */
	@RequestMapping(value="/page",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String  page(@RequestParam(value="currentPage",defaultValue="0",required=false)int currentPage,Model model) {
		model.addAttribute("pagemsg", t_userService.findByPage(currentPage));//���Է�ҳ����
		JSONArray jsonArray= JSONArray.fromObject(model);
		return jsonArray.toString();
	}



	/**
	 * �˵�
	 * @throws IOException 
	 */
	@RequestMapping(value="/shu",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String shu(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("�˵�");
		String usid=request.getParameter("usid");
		List list =t_userService.rolemunelist(usid);
		System.out.println("go kkkkkk");
		System.out.println("�˵�list:"+list);
		JSONArray jsonArray= JSONArray.fromObject(list);
		System.out.println("jsonArray��"+jsonArray.toString());
		return jsonArray.toString();

	}





	/**
	 * ����Ȩ��
	 * @return
	 */
	@RequestMapping(value="/keyall",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String keyall(HttpServletRequest request) {
		//���ܲ���
		String userid = request.getParameter("userid");
		String rid = request.getParameter("rid");
		T_USER_ROLE t_USER_ROLE=new T_USER_ROLE();
		t_USER_ROLE.setUserid(userid);
		t_USER_ROLE.setRid(rid);
		t_userService.mansave(t_USER_ROLE);
		return "success";
	}

	/**
	 * Ȩ���޸�
	 * @return
	 */
	@RequestMapping(value="/truupdate",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String truupdate(T_USER_ROLE t_USER_ROLE) {
		t_userService.turupd(t_USER_ROLE);
		return "success";
	}

	/**
	 * ��ѯְλ
	 * @return
	 */
	@RequestMapping(value="/manfiveall",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String manfiveall(HttpServletRequest request) {
		String uname=request.getParameter("uname");
		Object object=t_userService.manoneall(uname);
		JSONArray jsonArray= JSONArray.fromObject(object);
		return jsonArray.toString();
	}

	/**
	 * ͨ��userid��ѯ�м��
	 * @return
	 */
	@RequestMapping(value="/dongall",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String dongall(String userid) {
		List list=t_userService.dongoneall(userid);
		System.out.println("list:"+list);
		JSONArray jsonArray= JSONArray.fromObject(list);
		return jsonArray.toString();
	}

}
