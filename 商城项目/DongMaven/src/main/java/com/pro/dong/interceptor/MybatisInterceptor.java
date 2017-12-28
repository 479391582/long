package com.pro.dong.interceptor;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.PropertyException;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import com.pro.dong.util.ReflectHelper;



/**
*@author xingxing
*@version 
*@time 2017年11月16日 下午1:25:07 
*class explain：
*/

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class}) })
public class MybatisInterceptor  implements Interceptor {
	String dialect;

	public Object intercept(Invocation xing) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("intercept---intercept---intercept");
		RoutingStatementHandler rsh=(RoutingStatementHandler)xing.getTarget();
		System.out.println("执行的方法："+rsh.getBoundSql().getSql());
		BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(rsh, "delegate");
		MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");	
		String id=mappedStatement.getId().toString();
		System.out.println("这是我获取的xml执行的id："+id);
//		BoundSql boundSql = delegate.getBoundSql();
//		Object parameterObject = boundSql.getParameterObject();
//		ReflectHelper.setValueByFieldName(boundSql, "sql", "select * from t_user"); 
		return xing.proceed();
	}


	public Object plugin(Object arg0) {
		System.out.println("plugin---plugin---plugin");
		return Plugin.wrap(arg0,this);
	}


	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		dialect=arg0.get("dialect").toString();
		System.out.println("dialect:"+dialect);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
