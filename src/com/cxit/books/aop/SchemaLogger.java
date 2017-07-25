package com.cxit.books.aop;

import java.util.Arrays;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
//普通的Java类  基于Schema配置切面 方法参数必须相关接口
public class SchemaLogger {

	Logger logger = Logger.getLogger(SchemaLogger.class);
	//前置增强
	public void before(JoinPoint jPoint){
		logger.info("before---->调用"+jPoint.getTarget()+"的方法"+
				jPoint.getSignature().getName()+",传入参数是:"
				+Arrays.toString(jPoint.getArgs()));
	}
	//后置增强
	public void afterReturning(JoinPoint jPoint,Object rv){
		logger.info("AfterReturning<----调用"+jPoint.getTarget()+"的方法"+
				jPoint.getSignature().getName()+",返回值是:"
				+rv);
	}
	
	public void afterThrowing(JoinPoint jPoint,RuntimeException ex){
		logger.error("<--afterThrowing-->调用"+jPoint.getTarget()+"的方法"+
				jPoint.getSignature().getName()+",产生了异常:"
				+ex.getMessage());
	}
	
	public Object aroundLogger(ProceedingJoinPoint pjp){
		logger.info("<--aroundLogger--调用"+pjp.getTarget()+"的方法"+
				pjp.getSignature().getName()+",传入的参数是:"
				+Arrays.toString(pjp.getArgs()));
		try {
			Object retutn=pjp.proceed();//获得返回值
			logger.info("--aroundLogger-->调用"+pjp.getTarget()+"的方法"+
					pjp.getSignature().getName()+",返回值是:"
					+retutn);
			return retutn;
		} catch (Throwable ex) {
			//e.printStackTrace();
			logger.error("<--aroundLogger-->调用"+pjp.getTarget()+"的方法"+
					pjp.getSignature().getName()+",产生了异常:"
					+ex.getMessage());
		}//获得方法的返回值
		return null;
	}
}

