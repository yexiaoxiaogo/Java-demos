package io.github.yexiaoxiaogo.HelloWorld;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee("zhangsan");
		Employee emp2 = new Employee("lisi");
		
		emp1.empAge(26);
		emp1.empDesignation("高级程序员");
		emp1.empSalary(10000);
		emp1.printEmployee();
		
		emp2.empAge(21);
		emp2.empDesignation("初级程序员");
		emp2.empSalary(5000);
		emp2.printEmployee();

	}

}
