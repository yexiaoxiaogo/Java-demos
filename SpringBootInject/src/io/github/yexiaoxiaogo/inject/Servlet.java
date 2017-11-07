package io.github.yexiaoxiaogo.inject;

public class Servlet {
	
	@AutoInject
	Interface inter;
	
	public void runInterface() {
		System.out.println("run interface");
		inter.hello();
	}
}
