package io.github.yexiaoxiaogo.SpringDemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	private static BeanFactory factory;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductManage productManage = (ProductManage)factory.getBean("productManage");
		productManage.addUser();
		
	}

}
