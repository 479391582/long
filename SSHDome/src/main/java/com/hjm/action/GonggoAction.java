package com.hjm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;


public class GonggoAction {
	protected HttpServletRequest request = ServletActionContext.getRequest();
	protected HttpServletResponse response = ServletActionContext.getResponse();
	protected HttpSession session = request.getSession();
	
}
