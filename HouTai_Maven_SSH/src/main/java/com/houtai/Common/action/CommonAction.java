package com.houtai.Common.action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author 47939
 *
 */
public class CommonAction extends ActionSupport{
	protected HttpServletResponse response = ServletActionContext.getResponse();
	protected HttpServletRequest request = ServletActionContext.getRequest();
	protected Map map;
	protected String weizhi;
	
	public String getWeizhi() {
		return weizhi;
	}
	public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
	}
	protected String currPage;
	
	protected String qxusid;
	
	
	public String getCurrPage() {
		return currPage;
	}
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	public String getQxusid() {
		return qxusid;
	}
	public void setQxusid(String qxusid) {
		this.qxusid = qxusid;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	
	
	
}
