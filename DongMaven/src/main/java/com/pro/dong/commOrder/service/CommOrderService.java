package com.pro.dong.commOrder.service;

import java.util.List;
import java.util.Map;

import com.pro.dong.T_CUSTUMER.entity.T_CUSTUMER;
import com.pro.dong.commOrder.entity.CommOrder;
import com.pro.dong.commodity.entity.Commodity;
import com.pro.dong.page.PageBean;

public interface CommOrderService {
							
							
	  
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
		//购物车通过id查询
		List shopall(String stri);
	
		//获得总条数
				Object selectCount();
				//分页
				PageBean<Map<CommOrder,T_CUSTUMER> >findByPage(int currentPage);

				//通过name查询
				List nameall(String stri);	
							
							
							
}
