package com.pro.dong.T_user.service;

import java.util.List;
import java.util.Map;

import com.pro.dong.T_ROLE.entity.T_ROLE;
import com.pro.dong.T_user.entity.T_user;
import com.pro.dong.page.PageBean;

public interface T_userService {
							
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
//获得总条数
		Object selectCount();
		//分页
		PageBean<Map<T_user,T_ROLE> >findByPage(int currentPage);
			
		//菜单
				List rolemunelist(String str);	

				//赋予角色
				void mansave(Object object);		
							
				//T_USER_ROLE通过id查询
				List turoneall(String stri);				
				//权限修改
				void turupd(Object object);		
				//查询职位
				List manoneall(String stri);		
				//通过id查询中间表
				List dongoneall(String stri);
}
