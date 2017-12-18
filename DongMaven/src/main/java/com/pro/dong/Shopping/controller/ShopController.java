package com.pro.dong.Shopping.controller;

import java.io.IOException;
import java.util.List;

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
import com.pro.dong.Shopping.service.ShopService;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


//购物车
@Controller
@RequestMapping("/shop")
public class ShopController {
	       @Autowired
			private ShopService shopService;

			
			/**
			 * 查询全部
			 * @param response
			 * @throws IOException
			 */
			@RequestMapping(value="/all",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public void all(HttpServletResponse response) throws IOException {
				Object object= shopService.all();
				JSONArray jsonArray= JSONArray.fromObject(object);
				System.out.println("JSONARRAY:"+jsonArray.toString());
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jsonArray.toString());
				
			}
			
			/**
			 * 根据用户名查询
			 * 登录用户的购物车信息
			 * @return
			 * @throws IOException 
			 */
			@RequestMapping(value="/nameall",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public void nameall(HttpServletRequest request,HttpServletResponse response) throws IOException {
				String cname=request.getParameter("cname");
	               Object object=shopService.nameall(cname);
	               System.out.println("object:"+object);
				JSONArray jsonArray= JSONArray.fromObject(object);
				System.out.println("JSONARRAY:"+jsonArray.toString());
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jsonArray.toString());
	               
			}
			
			/**
			 * 添加购物车
			 * @return
			 */
			@RequestMapping("/save")
			@ResponseBody
			public String save(String cid,HttpServletRequest request) {
				                      System.out.println("进入注册");
				                      String cname=request.getParameter("cname");
				                      List list=shopService.oneall(cid);
				                     System.out.println("list:"+list);
				                     if(list.size()==0) {
				                    	 System.out.println("失败");
				                    	 return "error";
				                     }
				                 	JSONArray jsonArray= JSONArray.fromObject(list);
				                 	System.out.println("jsonArray:"+jsonArray);
				                 	 JSONObject object=(JSONObject) jsonArray.get(0);
				                 	Shop shop=new Shop();
									shop.setShname(object.getString("cname"));
									shop.setShprice(object.getString("cprice"));
									shop.setShtype(object.getString("ctype"));
									shop.setShbrand(object.getString("cbrand"));
									shop.setShdescribe(object.getString("describe"));
					               shop.setCname(cname);
									shopService.save(shop);
									System.out.println("shop:"+shop);
									System.out.println("添加成功！");
						     	return "success";
			
			}
			
			/**
			 * 删除
			 * @return
			 */
			@RequestMapping("/del")
			@ResponseBody
			public String del(String shid) {
				System.out.println("user删除！");
				shopService.del(shid);
				return "success";
			}
			
			/**
			 * 根据id查询
			 * @param shid
			 * @param response
			 * @throws IOException
			 */
			@RequestMapping(value="/oneall",method=RequestMethod.GET,produces="text/html;charset=utf-8")
			@ResponseBody
			public void oneall(String shid,HttpServletResponse response) throws IOException {
				List  list = shopService.shoponeall(shid);
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
					model.addAttribute("pagemsg", shopService.findByPage(currentPage));//回显分页数据
					JSONArray jsonArray= JSONArray.fromObject(model);
					  return jsonArray.toString();
				}
 			
				/**
				 * 清空登录用户的购物车
				 * 后查询购物车
				 * @return
				 * @throws IOException 
				 */
				@RequestMapping(value="/alldelect",method=RequestMethod.GET,produces="text/html;charset=utf-8")
				@ResponseBody
				public void alldelect(HttpServletRequest request,HttpServletResponse response) throws IOException {
					  String cname=request.getParameter("cname");
					shopService.alldel(cname);
					nameall(request, response);
				}
				
				/**
				 * 清空登录用户的购物车
				 * @return
				 * @throws IOException 
				 */
				@RequestMapping(value="/onealldelect",method=RequestMethod.GET,produces="text/html;charset=utf-8")
				@ResponseBody
				public String onealldelect(HttpServletRequest request) throws IOException {
					  String cname=request.getParameter("cname");
					shopService.alldel(cname);
					return "success";
				}
		

}
