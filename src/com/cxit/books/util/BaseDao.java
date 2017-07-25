package com.cxit.books.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 基础数据操作类
 * @author 钟森阳
 *
 */
public class BaseDao {
	private static SqlSessionFactory sessionFactory;
	static{
		try {
			//读取配置文件
			Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
			sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回操作数据库得session对象
	 * @return
	 */
	public static SqlSession openSession(){
		return sessionFactory.openSession();
	}
}
