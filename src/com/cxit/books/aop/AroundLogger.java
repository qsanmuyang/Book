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
		Object target = mic.getThis();//ִ�е�Ŀ�����
		Method method = mic.getMethod();//ִ�еķ���
		Object [] args = mic.getArguments();//�����Ĳ����б�
		logger.info(target+"ִ����"+method.getName()+"����Ĳ����ǣ�"+
		Arrays.toString(args));
		Object result=null;
		try {
			result=mic.proceed();//����Ŀ�귽��
			logger.debug(target+"ִ����"+method.getName()+"����ֵ��"+result);
		} catch (Exception e) {
			logger.error(target+"ִ����"+method.getName()+"���������쳣"+e.getMessage());
		}
		return result;
	}

}
