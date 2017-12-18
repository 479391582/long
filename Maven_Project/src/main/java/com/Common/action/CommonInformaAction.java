package com.Common.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.Login.bean.Custumer;
import com.Login.bean.RepairOrder;
import com.Login.bean.User;



/**
 * @author 47939
 *
 */
public class CommonInformaAction extends beasaction{
	protected HttpServletResponse response = ServletActionContext.getResponse();
	protected HttpServletRequest request = ServletActionContext.getRequest();
	protected String page;
	protected User user;
	protected Custumer custumer;
	protected String userid;
	protected Map map;
	protected RepairOrder repairOrder;
	public List<String> list;
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Custumer getCustumer() {
		return custumer;
	}
	public void setCustumer(Custumer custumer) {
		this.custumer = custumer;
	}
	public RepairOrder getRepairOrder() {
		return repairOrder;
	}
	public void setRepairOrder(RepairOrder repairOrder) {
		this.repairOrder = repairOrder;
	}
	
	
	
	
}
