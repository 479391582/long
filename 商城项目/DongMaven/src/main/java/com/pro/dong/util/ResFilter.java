package com.pro.dong.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.pro.dong.T_user.entity.T_user;

public class ResFilter implements Filter{

     
    private final static double DEFAULT_USERID= Math.random()*100000.0;  

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
           FilterChain chain) throws IOException, ServletException {
        //logger.info("test for MDC.");

       chain.doFilter(request, response);
    }
    public void init(FilterConfig Config) throws ServletException {
//     this.filterConfig = Config;
//     String ccc = Config.getServletContext().getInitParameter("cherset");
//     this.targetEncoding = Config.getInitParameter("cherset");

    }
}

