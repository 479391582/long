package com.Login.service;

import java.util.List;

import com.Login.bean.User;





/**
 * @author 47939
 *
 */
public interface LoginService {
	//注册
	void add(User user);
	//登陆
	List<?> login(Object object);
	//分页列表
	List<?> listpage(String pageno,String pagesize);
	//多少条数据
	int countorder();
	//删除
	void delete(Object object);
	//添加或修改
	boolean addorupd(Object object);
	//查询角色
	public List<?> urlistname(String name);
	//已名字查询存在不存在
	public List<?> username(String username); 

}
