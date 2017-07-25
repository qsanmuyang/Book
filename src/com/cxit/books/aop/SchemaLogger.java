package com.cxit.books.aop;

import java.util.Arrays;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
//��ͨ��Java��  ����Schema�������� ��������������ؽӿ�
public class SchemaLogger {

	Logger logger = Logger.getLogger(SchemaLogger.class);
	//ǰ����ǿ
	public void before(JoinPoint jPoint){
		logger.info("before---->����"+jPoint.getTarget()+"�ķ���"+
				jPoint.getSignature().getName()+",���������:"
				+Arrays.toString(jPoint.getArgs()));
	}
	//������ǿ
	public void afterReturning(JoinPoint jPoint,Object rv){
		logger.info("AfterReturning<----����"+jPoint.getTarget()+"�ķ���"+
				jPoint.getSignature().getName()+",����ֵ��:"
				+rv);
	}
	
	public void afterThrowing(JoinPoint jPoint,RuntimeException ex){
		logger.error("<--afterThrowing-->����"+jPoint.getTarget()+"�ķ���"+
				jPoint.getSignature().getName()+",�������쳣:"
				+ex.getMessage());
	}
	
	public Object aroundLogger(ProceedingJoinPoint pjp){
		logger.info("<--aroundLogger--����"+pjp.getTarget()+"�ķ���"+
				pjp.getSignature().getName()+",����Ĳ�����:"
				+Arrays.toString(pjp.getArgs()));
		try {
			Object retutn=pjp.proceed();//��÷���ֵ
			logger.info("--aroundLogger-->����"+pjp.getTarget()+"�ķ���"+
					pjp.getSignature().getName()+",����ֵ��:"
					+retutn);
			return retutn;
		} catch (Throwable ex) {
			//e.printStackTrace();
			logger.error("<--aroundLogger-->����"+pjp.getTarget()+"�ķ���"+
					pjp.getSignature().getName()+",�������쳣:"
					+ex.getMessage());
		}//��÷����ķ���ֵ
		return null;
	}
}

