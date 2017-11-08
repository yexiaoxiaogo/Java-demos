package io.github.yexiaoxiaogo.inject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Factory {
//	public <T> getBean(Class<T> claz) {
//		
//	}
	
	// spring boot 内部管理  bean 的类似代码，简易版本
	public Servlet getBean() throws IllegalArgumentException, IllegalAccessException {
		Servlet servlet = new Servlet();
		Field[] fields = Servlet.class.getDeclaredFields();
		
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getAnnotation(AutoInject.class) != null) {
				Field field = fields[i];
				field.setAccessible(true);
				field.set(servlet, new InterfaceImpl());
			}
		}
		return servlet;
	}
}
