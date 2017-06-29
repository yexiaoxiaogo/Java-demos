package io.github.yexiaoxiaogo.HelloWorld;

public class Puppy {
	int puppyage;
	public int getPuppyage() {
		System.out.println("小狗的年龄："+puppyage);
		return puppyage;
	}

	public void setPuppyage(int puppyage) {
		this.puppyage = puppyage;
	}

	public Puppy (String name) {
		System.out.println("小狗的名字是："+name);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Puppy myPuppy = new Puppy("小黄");
		myPuppy.setPuppyage(2);
		myPuppy.getPuppyage();
		System.out.println("通过对象调用年龄："+myPuppy.puppyage);
	}

}
