package com.cxit.books.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class AroundLogger implements MethodInterceptor {
	
	Logger logger = Logger.getLogger(AroundLogger.class);
	@Override
	public Object invoke(MethodInvocation mic) throws Throwable {
		Object target = mic.getThis();//执行的目标对象
		Method method = mic.getMethod();//执行的方法
		Object [] args = mic.getArguments();//方法的参数列表
		logger.info(target+"执行了"+method.getName()+"传入的参数是："+
		Arrays.toString(args));
		Object result=null;
		try {
			result=mic.proceed();//调用目标方法
			logger.debug(target+"执行了"+method.getName()+"返回值是"+result);
		} catch (Exception e) {
			logger.error(target+"执行了"+method.getName()+"方法发生异常"+e.getMessage());
		}
		return result;
	}

}
