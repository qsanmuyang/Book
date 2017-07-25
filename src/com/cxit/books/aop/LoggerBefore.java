package com.cxit.books.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LoggerBefore implements MethodBeforeAdvice {
	Logger log = Logger.getLogger(LoggerBefore.class);
	/**
	 * ǰ����ǿ����Ŀ����󷽷�ִ��ǰ֯�룩
	 * method ���õķ���
	 * arguments �����еĲ�������
	 * target Ŀ�����
	 */
	@Override
	public void before(Method method, Object[] arguments, Object target)
			throws Throwable {
		log.info("����"+target+"��"+method.getName()+
				"������������"+Arrays.toString(arguments));

	}

}
