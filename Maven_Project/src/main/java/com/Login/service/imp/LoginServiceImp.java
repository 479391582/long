package com.Login.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import com.Common.service.imp.CommonServiceImp;
import com.Login.bean.User;
import com.Login.service.LoginService;


/**
 * @author 47939
 *
 */
@Service("loginService")
public class LoginServiceImp extends CommonServiceImp implements LoginService{
	
	//·ÖÒ³
		@Override
		public List<?> listpage(String pageno, String pagesize) {
			String Hql="SELECT * FROM (  select ROWNUM AS LIMITNUM,u.*,r.* from t_user u join t_user_role ur on  ur.userid = u.userid join t_role r on r.rid =ur.roleid)"
					+ " WHERE LIMITNUM BETWEEN ("+pageno+"-1)*("+pagesize+") AND "+pageno+"*"+pagesize;
			return 	super.createSql(Hql);
		}
		public List<?> urlistname(String name) {
			String Hql="select u.*,r.* from t_user u "
					+ "join t_user_role ur on  ur.userid = u.userid "
					+ "join t_role r on r.rid =ur.roleid where u.username='"+name+"'";
			return super.createSql(Hql);
		}
		@Override
		public List<?> username(String username) {
			String sql="select * from t_user where username='"+username+"'";
			return super.createSql(sql);
		}
		@Override
		public int countorder() {
			return super.objectfindall(User.class).size();
		}
		@Override
		public void delete(Object object) {
			super.del(object);
		}
		@Override
		public boolean addorupd(Object object) {
			try {
				super.saveorupd(object);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		@Override
		public void add(User user) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public List<?> login(Object object) {
			// TODO Auto-generated method stub
			return null;
		}
}
