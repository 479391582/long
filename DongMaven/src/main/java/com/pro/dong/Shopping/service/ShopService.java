package com.pro.dong.Shopping.service;

import java.util.List;
import java.util.Map;

import com.pro.dong.Shopping.entity.Shop;
import com.pro.dong.page.PageBean;
import com.pro.dong.repairOrder.entity.RepairOrder;

public interface ShopService {
							
							
	  
		//查询全部
		List<?> all();
		//修改
		void upd(Object object);
		//删除
		void del(String str);
		//清空删除
		void alldel(String str);
		//商品表通过id查询
		List oneall(String stri);
		//添加
		void save(Object object);
		//通过name查询
		List nameall(String stri);
		//购物车通过id查询
		List shoponeall(String stri);
					
		//获得总条数
				Object selectCount();
				//分页
				PageBean<Shop> findByPage(int currentPage);	
							
							
}
