package com.pro.dong.commOrder.controller;

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

import com.pro.dong.Shopping.entity.Shop;
import com.pro.dong.T_CUSTUMER.entity.T_CUSTUMER;
import com.pro.dong.commOrder.entity.CommOrder;
import com.pro.dong.commOrder.service.CommOrderService;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


//商品订单
@Controller
@RequestMapping("/commOrder")
public class CommOrderController {
	       @Autowired
			private CommOrderService commOrderService;
			
			
			/**
			 * 查询全部
			 * @param response
			 * @throws IOException
			 */
			@RequestMapping(value="/all",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public void all(HttpServletResponse response) throws IOException {
				Object object= commOrderService.all();
				JSONArray jsonArray= JSONArray.fromObject(object);
				System.out.println("JSONARRAY:"+jsonArray.toString());
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jsonArray.toString());
				
			}
			
			/**
			 * 通过name查询
			 * @return
			 * @throws IOException 
			 */
			@RequestMapping(value="/nameall",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public String nameall(HttpServletRequest request) throws IOException {
				String cname=request.getParameter("cname");
				    List list=commOrderService.nameall(cname);
				    System.out.println("list:"+list);
			        JSONArray  jsonArray= JSONArray .fromObject(list);
			       System.out.println("JSONARRAY:"+jsonArray.toString());
				return jsonArray.toString();
			}
			
			
			
			/**
			 * 添加
			 * @return
			 */
			@RequestMapping("/save")
			@ResponseBody
			public String save(String shid,HttpServletRequest request) {
				System.out.println("进入添加");
				   String cname = request.getParameter("cname");
				   String cphone = request.getParameter("cphone");
                   List list=commOrderService.shopall(shid);
                   System.out.println("list:"+list);
                   if(list.size()==0) {
                	   System.out.println("添加失败");
                	   return "error";
                   }
              	JSONArray jsonArray= JSONArray.fromObject(list);
              	System.out.println("jsonArray:"+jsonArray);
              	 JSONObject object=(JSONObject) jsonArray.get(0);
              	CommOrder commOrder=new CommOrder();
              	commOrder.setConame(object.getString("shname"));
				commOrder.setCoprice(object.getString("shprice"));
				commOrder.setCotype(object.getString("shtype"));
				commOrder.setCobrand(object.getString("shbrand"));
				commOrder.setStatus("未派工");
            	commOrder.setCname(cname);
				commOrder.setCphone(cphone);
				commOrderService.save(commOrder);
					System.out.println("commOrder:"+commOrder);
					System.out.println("添加成功！");
		     	return "success";
              	  

			}
			
			/**
			 * 删除
			 * @return
			 */
			@RequestMapping("/del")
			@ResponseBody
			public String del(String coid) {
				System.out.println("user删除！");
				commOrderService.del(coid);
				return "success";
			}
			
			/**
			 * 修改
			 * @return
			 * @throws UnsupportedEncodingException 
			 */
			@RequestMapping("/update")
			@ResponseBody
			public String update(CommOrder commOrder,HttpServletRequest request) throws UnsupportedEncodingException {
				request.setCharacterEncoding("UTF-8");
				commOrderService.upd(commOrder);
				return "success";
			}
			
			/**
			 * 根据id查询
			 * @return
			 * @throws IOException 
			 */
			@RequestMapping(value="/oneselect",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public void oneselect(String coid,HttpServletResponse response) throws IOException {
				List  list = commOrderService.oneall(coid);
		        System.out.println("list:"+list);
		        JSONArray  jsonArray= JSONArray .fromObject(list);
		       System.out.println("JSONARRAY:"+jsonArray.toString());
		      response.setCharacterEncoding("utf-8");
		      response.getWriter().write(jsonArray.toString());
				
			}
			
		
			/**
			 * 分页
			 */
				@RequestMapping(value="/page",method=RequestMethod.GET,produces="text/html;charset=utf-8")
				@ResponseBody
	 			public String  page(@RequestParam(value="currentPage",defaultValue="0",required=false)int currentPage,Model model) {
					model.addAttribute("pagemsg", commOrderService.findByPage(currentPage));//回显分页数据
					JSONArray jsonArray= JSONArray.fromObject(model);
					  return jsonArray.toString();
	 			}
		

}
