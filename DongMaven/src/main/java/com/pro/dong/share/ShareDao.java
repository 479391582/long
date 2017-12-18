package com.pro.dong.share;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.pro.dong.commodity.entity.Commodity;

public interface ShareDao {

	       //登录查询
			Object  getUserByUsernameAndPassword(String str,Object object);
			//查询全部
			List<?> all(String str);
			//修改
			void upd(String str,Object object);
			//删除
			void del(String stri,String str);
			//all删除
			void alldel(String stri,String str);
			//通过id查询
			List oneall(String str,String stri);
			//添加
			void save(String str,Object object);
			//树形菜单
			List<?> login(String str);
			//根据用户名查询
			List<?> nameall(String str,String strs);
			//通过id查询
			Object objectall(String str,String stri);
			//通过id查询
			void voidall(String str,String stri);
			//通过id查询
			Map mapall(String str,String stri);
			//
			List<Object> alist(String str,String stri);
			   /**
		     * 查询用户记录总数
		     * @return
		     */
			Object selectCount(String str);
		    /**
		     * 分页操作，调用findByPage limit分页方法
		     * @param map
		     * @return
		     */
		    List<?> findByPage(String str,HashMap<String,Object> map);
		
			
			
			
			
}
