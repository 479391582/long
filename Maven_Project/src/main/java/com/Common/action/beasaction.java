package com.Common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.Login.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;



/**
 * @author 47939
 *
 */
public class beasaction extends ActionSupport{
	@Autowired
	protected  LoginService loginService;
	
	
	
}
