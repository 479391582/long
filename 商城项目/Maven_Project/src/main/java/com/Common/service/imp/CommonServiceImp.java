package com.Common.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Common.service.CommonService;



/**
*@author xingxing
*@version 
*@time 2017骞�10鏈�19鏃� 涓嬪崍9:47:40 
*class explain锛歴ervice 灞� 鎺ュ彛
*/
@Service("commonService")
public class CommonServiceImp implements CommonService{
	
	@Override
	public boolean saveorupd(Object obj) {
		return false;
	}

	@Override
	public boolean del(Object obj) {
		return false;
		// TODO Auto-generated method stub
	}

	@Override
	public List<?> objectfind(Object obj) {
		return null;
		// TODO Auto-generated method stub
	}
	@Override
	public List<?> findid(String obj) {
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public List<?> objectfindall(Class clazz) {
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public List createSql(String sql) {
		return null;
		// TODO Auto-generated method stub
	}

	public CommonServiceImp() {
		System.out.println("----CommonServiceImp----");
	}

	@Override
	public List<?> listpage(String sql, Class clazz) {
		return null;
		// TODO Auto-generated method stub
	}
}
