package com.cxit.books.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
//������ǿ
public class LoggerAfterReturing implements AfterReturningAdvice {
	
	Logger logger = Logger.getLogger(LoggerAfterReturing.class);
	@Override
	public void afterReturning(Object returnVlue, Method method, Object[] arguments,
			Object target) throws Throwable {
		logger.info("����"+target+"��"+method.getName()+
				"������"+Arrays.toString(arguments)+"����ֵΪ"+returnVlue);

	}

}
