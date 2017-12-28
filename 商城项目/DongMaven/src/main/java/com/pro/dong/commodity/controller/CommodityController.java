package com.pro.dong.commodity.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.dong.commodity.entity.Commodity;
import com.pro.dong.commodity.service.CommodityService;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


//��Ʒ��
@Controller
@RequestMapping("/commodity")
public class CommodityController {
	       @Autowired
			private CommodityService commodityService;
			
			
			/**
			 * ��ѯȫ��
			 * @param response
			 * @throws IOException
			 */
			@RequestMapping(value="/all",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public void all(HttpServletResponse response) throws IOException {
				Object object= commodityService.all();
				System.out.println("object:"+object);
				JSONArray jsonArray= JSONArray.fromObject(object);
				System.out.println("JSONARRAY:"+jsonArray.toString());
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jsonArray.toString());
				
			}
			
		
			
			/**
			 * ���
			 * @return
			 * @throws UnsupportedEncodingException 
			 */
			@RequestMapping(value="/save",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public String save(HttpServletRequest request) throws UnsupportedEncodingException {
				System.out.println("����ע��");
				//ʹ������ռ�����
				request.setCharacterEncoding("UTF-8");
				String cname = request.getParameter("cname");
				String cprice = request.getParameter("cprice");
				String fid = request.getParameter("fid");
				String ctype = request.getParameter("ctype");
				String cbrand = request.getParameter("cbrand");
				String describe = request.getParameter("describe");
				Commodity commodity=new Commodity();
				commodity.setCname(cname);
				commodity.setCprice(cprice);
				commodity.setFid(fid);
				commodity.setCtype(ctype);
				commodity.setCbrand(cbrand);
				commodity.setDescribe(describe);
				commodityService.save(commodity);
				System.out.println("commodity:"+commodity);
				return "success";
			}
			
			/**
			 * ɾ��
			 * @return
			 */
			@RequestMapping(value="/del",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public String del(String cid) {
				System.out.println("userɾ����");
				commodityService.del(cid);
				return "success";
			}
			
			/**
			 * �޸�
			 * @return
			 * @throws UnsupportedEncodingException 
			 */
			@RequestMapping(value="/update",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public String update(Commodity commodity,HttpServletRequest request) throws UnsupportedEncodingException {
				request.setCharacterEncoding("UTF-8");
				commodityService.upd(commodity);
				return "success";
			}
			
			/**
			 * ����id��ѯ
			 * @return
			 * @throws IOException 
			 */
			@RequestMapping(value="/oneselect",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public void oneselect(String cid,HttpServletResponse response) throws IOException {
				List  list = commodityService.oneall(cid);
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
				model.addAttribute("pagemsg", commodityService.findByPage(currentPage));//���Է�ҳ����
				JSONArray jsonArray= JSONArray.fromObject(model);
				  return jsonArray.toString();
 			}
		

}
