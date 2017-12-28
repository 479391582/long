package com.pro.dong.share;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.dong.commodity.entity.Commodity;


@Repository("shareDao")
public class  ShareDaoImpl implements  ShareDao{
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public Object getUserByUsernameAndPassword(String str,Object object) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(str, object);
	}

	public List<?> all(String str) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(str);
	}

	public void upd(String str, Object object) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(str, object);
	}

	public void del(String stri, String str) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete(stri, str);
	}

	public List oneall(String str, String stri) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(str, stri);
	}

	public void save(String str, Object object) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert(str, object);
	}

	public List<?> login(String str) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(str);
	}

	@Override
	public List<?> nameall(String str, String strs) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(str, strs);
	}

	@Override
	public Object objectall(String str, String stri) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(str, stri);
	}

	@Override
	public void voidall(String str, String stri) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.selectList(str, stri);
	}

	@Override
	public Map mapall(String str, String stri) {
		// TODO Auto-generated method stub
		return (Map) sqlSessionTemplate.selectList(str, stri);
	}

	@Override
	public List<Object> alist(String str, String stri) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(str, stri);
	}

	@Override
	public Object selectCount(String str) {
		// TODO Auto-generated method stub
		return (int) sqlSessionTemplate.selectList(str).get(0);
		
	}

	@Override
	public List<?> findByPage(String str,HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(str, map);
	}

	@Override
	public void alldel(String stri,String str) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete(stri,str);
	}

	
	

	

	

	

	

	


}
