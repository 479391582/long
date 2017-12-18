package com.hjm.action;

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
		System.out.println("jinqu");
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext ac=invocation.getInvocationContext();
		HttpSession session=request.getSession();
		String tmpStr = request.getRequestURI().substring(request.getRequestURI().indexOf("/") + 1);
		System.out.println("URL:"+tmpStr);
		 if(tmpStr.contains("login.action")) {
			 return invocation.invoke();
		 }else if (tmpStr.contains("all.action")) {
			 return invocation.invoke();
		}else if (tmpStr.contains("shouye.action")) {
			 return invocation.invoke();
		}else if (tmpStr.contains("zhuce.action")) {
			 return invocation.invoke();
		}else if (tmpStr.contains("duanxin.action")) {
			 return invocation.invoke();
		}
		 
		 if(session.getAttribute("user")==null) {
			 System.out.println("user:"+session.getAttribute("user"));
				return "nologin";
			}
		return invocation.invoke();

	}
}
