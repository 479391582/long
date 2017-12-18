package com.Common.service;

import java.util.List;

/**
 * @author 47939
 *
 */
public interface CommonService {
	/**
	 * @author xingxing
	 * @date 2017-10-19 21:11:16
	 * @param obj
	 * @return boolean
	 * 新增或修改
	 */
	boolean saveorupd(Object obj);
	
	/**
	 * @author xingxing
	 * @date 2017-10-19 21:13:57
	 * @param obj，传入参数 必须有主键，以主键作为删除条件
	 * @return boolean
	 * 以对象作为参数
	 * 删除 
	 */
	boolean del(Object obj);
		
	/**
	 * @author xingxing
	 * @date 2017-10-19 21:15:17
	 * @param class_name
	 * @return List
	 * 以ID作为条件，查询 对象,单条数据
	 */
	List<?> findid(String obj);
	/**
	 * @author xingxing
	 * @date 2017-10-19 21:15:17
	 * @param class_name
	 * @return List
	 * 以ID作为条件，查询 对象,单条数据(chen)
	 */
	List<?> objectfind(Object obj);
	
	/**
	 * @author xingxing
	 * @date 2017-10-19 21:18:20
	 * @return List<?>
	 * 查询 某个实体的所有数据，多条数据
	 */
	List<?> objectfindall(Class clazz);
	
	
	/**
	 * @author xingxing
	 * @date 2017-10-19 21:24:07
	 * @param sql
	 * @return List
	 * 执行Sql 语句,返回List
	 */
	List createSql(String sql); 
	/**
	 * @author longlong
	 * @date 2017-10-19 21:24:07
	 * @param sql
	 * @return list
	 * 分页查询
	 */
	List<?> listpage(String sql,Class clazz);
}
