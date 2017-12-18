package com.Login.dynproxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;


/**
 * @author 47939
 *
 */
@Aspect
@Component
public class AopLog {
	  private final Logger logger = LoggerFactory.getLogger(this.getClass());
	  private String requestPath = null ; // �����ַ
	  private String userName = null ; // �û���
	  private Map<?,?> inputParamMap = null ; // �������
	  private Map<String, Object> outputParamMap = null; // ���������
	  private long startTimeMillis = 0; // ��ʼʱ��
	  private long endTimeMillis = 0; // ����ʱ��

	  /**
	   * 
	   * @Title��doBeforeInServiceLayer
	   * @Description: ��������ǰ���� 
	   *  ��¼��ʼʱ�� 
	   * @author xingxing
	   * @param joinPoint
	   */
	  @Before("execution(* com.hupu.service.*.*.*(..))")
	  public void doBeforeInServiceLayer(JoinPoint joinPoint) {
	    startTimeMillis = System.currentTimeMillis(); // ��¼������ʼִ�е�ʱ��
	    System.out.println("��ʼʱ��"+startTimeMillis);
	  }

	  /**
	   * 
	   * @Title��doAfterInServiceLayer
	   * @Description: �������ú󴥷� 
	   *  ��¼����ʱ��
	   * @author xingxing
	   * @param joinPoint
	   */
	  @After("execution(* com.hupu.service.*.*.*(..))")
	  public void doAfterInServiceLayer(JoinPoint joinPoint) {
	    endTimeMillis = System.currentTimeMillis(); // ��¼����ִ����ɵ�ʱ��
	    System.out.println("����ʱ��"+endTimeMillis);
	    this.printOptLog();
	  }

	  /**
	   * 
	   * @Title��doAround
	   * @Description: ���ƴ��� 
	   * @author xingxing
	   * @param pjp
	   * @return
	   * @throws Throwable
	   */
	  @Around("execution(* com.hupu.service.*.*.*(..))")
	  public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
	    /**
	     * 1.��ȡrequest��Ϣ
	     * 2.����request��ȡsession
	     * 3.��session��ȡ����¼�û���Ϣ
	     */
	    RequestAttributes ra = RequestContextHolder.getRequestAttributes();
	    ServletRequestAttributes sra = (ServletRequestAttributes)ra;
	    HttpServletRequest request = sra.getRequest();
	    // ��session�л�ȡ�û���Ϣ
	    HttpSession session=request.getSession();
	    String loginInfo = (String) session.getAttribute("username");
	    userName=loginInfo;
//	    if(loginInfo != null && !"".equals(loginInfo)){
//	      userName = loginInfo;
//	    }else{
//	      userName = "�û�δ��¼" ;
//	    }
	    // ��ȡ�������
	    inputParamMap = request.getParameterMap();
	    // ��ȡ�����ַ
	    requestPath = request.getRequestURI();
	    
	    // ִ���귽���ķ���ֵ������proceed()�������ͻᴥ������㷽��ִ��
	    outputParamMap = new HashMap<String, Object>();
	    Object result = pjp.proceed();// result��ֵ���Ǳ����ط����ķ���ֵ
	    outputParamMap.put("result", result); 
	    return result;
	  }

	  /**
	   * 
	   * @Title��printOptLog
	   * @Description: �����־ 
	   * @author xingxing
	   */
	  private void printOptLog() {
	    Gson gson = new Gson(); // ��Ҫ�õ�google��gson������
	    String optTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);
	    logger.info("\n user��"+userName
	        +"  url��"+requestPath+"; op_time��" + optTime + " pro_time��" + (endTimeMillis - startTimeMillis) + "ms ;"
	        +" param��"+gson.toJson(inputParamMap)+";"+"\n result��"+gson.toJson(outputParamMap));
	  }
}