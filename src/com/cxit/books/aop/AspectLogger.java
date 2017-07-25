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
		logger.info("-->����"+jPoint.getTarget()+"�ķ���"+jPoint.getSignature().getName()+
				",��������ǣ�"+Arrays.toString(jPoint.getArgs()));
	}
	@AfterReturning(pointcut="execution(* com.cxit.books..*.*(..))",returning="returnValue")
	public void afterReturning(JoinPoint jPoint,Object returnValue){
		logger.info("<--����"+jPoint.getTarget()+"�ķ���"+jPoint.getSignature().getName()+
				",����ֵ�ǣ�"+returnValue);
	}
}
