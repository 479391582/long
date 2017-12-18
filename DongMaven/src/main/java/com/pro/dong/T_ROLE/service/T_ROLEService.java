package com.pro.dong.T_ROLE.service;

import java.util.List;
import java.util.Map;

import com.pro.dong.T_MENU.entity.T_MENU;
import com.pro.dong.T_ROLE.entity.T_ROLE;
import com.pro.dong.page.PageBean;

public interface T_ROLEService {
							
							
	  
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
		PageBean<T_ROLE> findByPage(int currentPage);
					
							
							
							
}
