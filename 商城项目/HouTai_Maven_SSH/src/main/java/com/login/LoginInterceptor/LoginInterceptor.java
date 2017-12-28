package com.login.LoginInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author 47939
 *
 */
public class LoginInterceptor extends  AbstractInterceptor  {
	private static final long serialVersionUID = -6559072959835076341L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext ac=invocation.getInvocationContext();
		HttpSession session=request.getSession();
		String tmpStr = request.getRequestURI().substring(request.getRequestURI().indexOf("/") + 1);
		System.out.println("URL:"+tmpStr);
//		if (tmpStr.contains("login.action") ) {
//			System.out.println("½øÈëµÇÂ¼");
//			return invocation.invoke();
//		}else if(tmpStr.contains("add.action")) {
//			return invocation.invoke();
//		}else if(tmpStr.contains("regist.action")) {
//			return invocation.invoke();
//		}else if(tmpStr.contains("query.action")) {
//			return invocation.invoke();
//		}else if(tmpStr.contains("delete.action")) {
//			return invocation.invoke();
//		}else if(tmpStr.contains("addtz.action")) {
//			return invocation.invoke();
//		}else if(tmpStr.contains("tiaozhuan.action")) {
//			return invocation.invoke();
//		}else if(tmpStr.contains("role.action")) {
//			return invocation.invoke();
//		}else if(tmpStr.contains("UserandRole.action")) {
//			return invocation.invoke();
//		}else if(tmpStr.contains("menushow.action")) {
//			return invocation.invoke();
//		}
//		else if(tmpStr.contains("Rolepage.action")) {
//			return invocation.invoke();
//		}
//		else if(tmpStr.contains("LoginSelectValue.action")) {
//			return invocation.invoke();
//		}
//		else if(tmpStr.contains("Distribute.action")) {
//			return invocation.invoke();
//		}
//		else if(tmpStr.contains("tzgetll.action")) {
//			return invocation.invoke();
//		}
//		else if(session.getAttribute("user")==null) {
//			return "nologin";
//		}else {
//			System.out.println("user:"+session.getAttribute("user"));
//			return invocation.invoke();
//		}
		if(tmpStr.contains("login.action")) {
			return invocation.invoke();
		}
		if(session.getAttribute("user")==null) {
			return "nologin";
		}
		return invocation.invoke();
	}
}
