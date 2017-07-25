package com.cxit.books.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LoggerBefore implements MethodBeforeAdvice {
	Logger log = Logger.getLogger(LoggerBefore.class);
	/**
	 * 前置增强（在目标对象方法执行前织入）
	 * method 调用的方法
	 * arguments 方法中的参数数组
	 * target 目标对象
	 */
	@Override
	public void before(Method method, Object[] arguments, Object target)
			throws Throwable {
		log.info("调用"+target+"的"+method.getName()+
				"方法，传入了"+Arrays.toString(arguments));

	}

}
