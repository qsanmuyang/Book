package com.cxit.books.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
//后置增强
public class LoggerAfterReturing implements AfterReturningAdvice {
	
	Logger logger = Logger.getLogger(LoggerAfterReturing.class);
	@Override
	public void afterReturning(Object returnVlue, Method method, Object[] arguments,
			Object target) throws Throwable {
		logger.info("调用"+target+"的"+method.getName()+
				"传入了"+Arrays.toString(arguments)+"返回值为"+returnVlue);

	}

}
