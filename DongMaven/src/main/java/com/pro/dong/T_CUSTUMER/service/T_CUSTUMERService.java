package com.pro.dong.T_CUSTUMER.service;

import java.util.List;
import java.util.Map;

import com.pro.dong.T_CUSTUMER.entity.T_CUSTUMER;
import com.pro.dong.page.PageBean;
import com.pro.dong.repairOrder.entity.RepairOrder;

public interface T_CUSTUMERService {
							
							
	  //登录查询
			Object  getUserByUsernameAndPassword(Object object);
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
		//根据用户名查询
		List<?> nameall(String strs);
		//查询角色全部
		List<?> manall();
		//赋予角色
		void mansave(Object object);
		//菜单
		List rolemunelist(String str);		
		//获得总条数
				Object selectCount();
				//分页
				PageBean<T_CUSTUMER> findByPage(int currentPage);	
				//通过电话号查询
				List openoneall(String stri);
}
