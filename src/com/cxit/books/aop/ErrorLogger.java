package com.cxit.books.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class ErrorLogger implements ThrowsAdvice {
	
	Logger log = Logger.getLogger(ErrorLogger.class);
	
	public void afterThrowing(Method method,Object[] arguments,Object target,
			Exception ex){
		log.error(method.getName()+"∑¢…˙“Ï≥£"+ex.getMessage());
	}
}
