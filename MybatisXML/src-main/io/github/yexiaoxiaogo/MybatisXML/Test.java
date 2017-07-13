package io.github.yexiaoxiaogo.MybatisXML;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			Websites websites = (Websites) session
					.selectOne("io.github.yexiaoxiaogo.MybatisXML.WebsitesMapper.selectWebsitesByID", 1);
			System.out.println(websites.getName());
			System.out.println(websites.getUrl());
		} finally {
			session.close();
		}
	}

}
