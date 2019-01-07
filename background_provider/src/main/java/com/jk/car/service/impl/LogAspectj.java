/** 
 * <pre>项目名称:user_wd 
 * 文件名称:LogAspectj.java 
 * 包名:com.jk.wd.aspectj 
 * 创建日期:2018年10月20日下午12:55:43 
 * Copyright (c) 2018, All Rights Reserved.</pre> 
 */  
package com.jk.car.service.impl;

import java.util.Date;


import javax.servlet.http.HttpServletRequest;

import com.jk.car.model.LogBean;
import com.jk.car.model.UserBean;
import com.jk.car.utils.IPUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;




/** 
 * <pre>项目名称：user_wd    
 * 类名称：LogAspectj    
 * 类描述：    
 * 创建人：王栋   
 * 创建时间：2018年10月20日 下午12:55:43    
 * 修改人：王栋      
 * 修改时间：2018年10月20日 下午12:55:43    
 * 修改备注：       
 * @version </pre>    
 */
@Aspect
@Component
public class LogAspectj {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Pointcut("execution(* com.jk.car.service..*Impl.*(..))")
	public void logPointCut() {}

	@AfterReturning(value="logPointCut()",argNames = "rtv", returning = "rtv")
	public void saveLog(JoinPoint joinPoint,Object rtv) {

		// 判断参数
		if (joinPoint.getArgs() == null) {// 没有参数
			return;
		}

		LogBean logBean = new LogBean();
		logBean.setCreateTime(new Date());
		//获取类名
		String simpleName = joinPoint.getTarget().getClass().getSimpleName();
		logBean.setClassName(simpleName);
		//获取方法名
		String name = joinPoint.getSignature().getName();
		logBean.setMethod(name);
		StringBuffer stringBuffer = new StringBuffer();
		//获取方法请求参数
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			String str = args[i] == null ? ""  : args[i].toString();
			stringBuffer.append("参数【").append(i).append(str).append("】");
		}
		logBean.setReqParams(stringBuffer.toString());
		//返回参数
		if (rtv != null) {
			logBean.setRespParams(rtv.toString());
		}
		//spring aop输出日志中获取request的post参数
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
		if (sra != null) {
			HttpServletRequest request = sra.getRequest();
			//控制层url
			logBean.setUrl(request.getRequestURL().toString());
			UserBean book = (UserBean) request.getSession().getAttribute("dept");
			if (book != null) {
				logBean.setUserId(book.getUsername());
			}
			logBean.setIp(IPUtil.getIp(request));
		}
		mongoTemplate.save(logBean);
	}
	
}
