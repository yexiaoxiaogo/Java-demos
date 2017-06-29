package io.github.yexiaoxiaogo.HelloWorld;

public class Employee {
	String name;
	int age;
	String designation;
	double salary;
	
	public Employee(String name){
		this.name =name;
	}
	
	public void empAge(int empAge){
		age = empAge;
	}
	
	public void empDesignation(String empDesig){
		designation = empDesig;
	}
	
	public void empSalary(double empSalary){
		salary = empSalary;
	}
	
	public void printEmployee() {
		System.out.println("名字："+name+" "+"年龄:"+age+" "+"职位:"+designation+" "+"薪水:"+salary);
	}

}
