package com.cxit.books.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxit.books.biz.impl.BookBizImpl;
import com.cxit.books.biz.impl.IitemsBizImpl;
import com.cxit.books.dao.impl.IitemsDaoImpl;
import com.cxit.books.dao.impl.OrdersDaoImpl;



public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext acxt=new ClassPathXmlApplicationContext("applicationContext.xml");
		OrdersDaoImpl impl=(OrdersDaoImpl) acxt.getBean("ordersDaoImpl");
		System.out.println(impl.getMaxOid());
	}

}
