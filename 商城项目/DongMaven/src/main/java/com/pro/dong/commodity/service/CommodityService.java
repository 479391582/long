package com.pro.dong.commodity.service;

import java.util.List;
import java.util.Map;

import com.pro.dong.commodity.entity.Commodity;
import com.pro.dong.page.PageBean;

public interface CommodityService {
							
							
	  
		//查询全部
		List<?> all();
		//修改
		void upd(Object object);
		//删除
		void del(String str);
		//通过id查询
		List oneall(String stri);
		//添加
		void save(Object object);
		//获得总条数
		Object selectCount();
		//分页
		PageBean<Commodity> findByPage(int currentPage);
							
							
							
}
