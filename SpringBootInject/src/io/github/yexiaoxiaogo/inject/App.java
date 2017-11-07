package io.github.yexiaoxiaogo.inject;

public class App {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Servlet servlet = new Factory().getBean();
		servlet.runInterface();
	}
}
