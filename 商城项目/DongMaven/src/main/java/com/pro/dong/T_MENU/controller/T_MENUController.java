package com.pro.dong.T_MENU.controller;

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

import com.pro.dong.T_CUSTUMER.entity.T_CUSTUMER;
import com.pro.dong.T_CUSTUMER.service.T_CUSTUMERService;
import com.pro.dong.T_MENU.entity.T_MENU;
import com.pro.dong.T_MENU.service.T_MENUService;
import com.pro.dong.commOrder.entity.CommOrder;
import com.pro.dong.commOrder.service.CommOrderService;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


//菜单表
@Controller
@RequestMapping("/t_MENU")
public class T_MENUController {
	@Autowired
	private T_MENUService t_MENUService;


	/**
	 * 查询全部
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/all",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public void all(HttpServletResponse response) throws IOException {
		Object object= t_MENUService.all();
		JSONArray jsonArray= JSONArray.fromObject(object);
		System.out.println("JSONARRAY:"+jsonArray.toString());
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonArray.toString());

	}

	/**
	 * 添加
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println("进入注册");
		//使用组件收集参数
		request.setCharacterEncoding("utf-8");
		String mname = request.getParameter("mname");
		String fid = request.getParameter("fid");
		String describe = request.getParameter("describe");
		T_MENU t_MENU=new T_MENU();
		t_MENU.setMname(mname);
		t_MENU.setFid(fid);
		t_MENU.setDescribe(describe);
		t_MENUService.save(t_MENU);
		System.out.println("t_MENU:"+t_MENU);
		return "success";
	}

	/**
	 * 删除
	 * @return
	 */
	@RequestMapping("/del")
	@ResponseBody
	public String del(String mid) {
		System.out.println("user删除！");
		t_MENUService.del(mid);
		return "success";
	}

	/**
	 * 修改
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String update(T_MENU t_MENU,HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		t_MENUService.upd(t_MENU);
		return "success";
	}

	/**
	 * 根据id查询
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/oneselect",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public void oneselect(String mid,HttpServletResponse response) throws IOException {
		List  list = t_MENUService.oneall(mid);
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
		model.addAttribute("pagemsg", t_MENUService.findByPage(currentPage));//回显分页数据
		JSONArray jsonArray= JSONArray.fromObject(model);
		return jsonArray.toString();
	}
	//日志显示
	@RequestMapping(value="/rizhi",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String  rizhi() {
		List<?> maps=t_MENUService.getrizhi();
		JSONArray jsonArray=JSONArray.fromObject(maps);
		return jsonArray.toString();
	}	


}
