package com.pro.dong.repairOrder.controller;

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


import com.pro.dong.repairOrder.entity.RepairOrder;
import com.pro.dong.repairOrder.service.RepairOrderService;

import net.sf.json.JSONArray;



//维修订单
@Controller
@RequestMapping("/repairOrder")
public class RepairOrderController {
	       @Autowired
			private RepairOrderService repairOrderService;
			
			
			/**
			 * 查询全部
			 * @param response
			 * @throws IOException
			 */
			@RequestMapping(value="/all",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public void all(HttpServletResponse response) throws IOException {
				Object object= repairOrderService.all();
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
				    List list=repairOrderService.nameall(cname);
				    System.out.println("list:"+list);
			        JSONArray  jsonArray= JSONArray .fromObject(list);
			       System.out.println("JSONARRAY:"+jsonArray.toString());
				return jsonArray.toString();
			}
			
			/**
			 * 添加
			 * @return
			 * @throws UnsupportedEncodingException 
			 */
			@RequestMapping(value="/save",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public String save(HttpServletRequest request) throws UnsupportedEncodingException {
				System.out.println("进入注册");
				//使用组件收集参数
				request.setCharacterEncoding("UTF-8");
				String rtype = request.getParameter("rtype");
				String rbrand = request.getParameter("rbrand");
				String fault = request.getParameter("fault");
				String remarks = request.getParameter("remarks");
				String cname = request.getParameter("cname");
				String cphone = request.getParameter("cphone");
				RepairOrder repairOrder=new RepairOrder();
				repairOrder.setRtype(rtype);
				repairOrder.setRbrand(rbrand);
				repairOrder.setFault(fault);
				repairOrder.setRemarks(remarks);
				repairOrder.setStatus("未派工");
				repairOrder.setCname(cname);
				repairOrder.setCphone(cphone);
				repairOrderService.save(repairOrder);
				System.out.println("repairOrder:"+repairOrder);
				return "success";
			}
			
			/**
			 * 删除
			 * @return
			 */
			@RequestMapping("/del")
			@ResponseBody
			public String del(String reid) {
				System.out.println("user删除！");
				repairOrderService.del(reid);
				return "success";
			}
			
			/**
			 * 修改
			 * @return
			 * @throws UnsupportedEncodingException 
			 */
			@RequestMapping("/update")
			@ResponseBody
			public String update(RepairOrder repairOrder,HttpServletRequest request) throws UnsupportedEncodingException {
				request.setCharacterEncoding("UTF-8");
				repairOrderService.upd(repairOrder);
				return "success";
			}
			
			/**
			 * 根据id查询
			 * @return
			 * @throws IOException 
			 */
			@RequestMapping(value="/oneselect",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public void oneselect(String reid,HttpServletResponse response) throws IOException {
				List  list = repairOrderService.oneall(reid);
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
					model.addAttribute("pagemsg", repairOrderService.findByPage(currentPage));//回显分页数据
					JSONArray jsonArray= JSONArray.fromObject(model);
					  return jsonArray.toString();
				}
 			
		

}
