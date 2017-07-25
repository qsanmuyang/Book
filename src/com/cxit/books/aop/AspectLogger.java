package com.cxit.books.aop;


import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectLogger {
	Logger logger = Logger.getLogger(AspectLogger.class);
	@Before("execution(* com.cxit.books..*.*(..))")
	public  void before(JoinPoint jPoint){
		logger.info("-->调用"+jPoint.getTarget()+"的方法"+jPoint.getSignature().getName()+
				",传入参数是："+Arrays.toString(jPoint.getArgs()));
	}
	@AfterReturning(pointcut="execution(* com.cxit.books..*.*(..))",returning="returnValue")
	public void afterReturning(JoinPoint jPoint,Object returnValue){
		logger.info("<--调用"+jPoint.getTarget()+"的方法"+jPoint.getSignature().getName()+
				",返回值是："+returnValue);
	}
}
