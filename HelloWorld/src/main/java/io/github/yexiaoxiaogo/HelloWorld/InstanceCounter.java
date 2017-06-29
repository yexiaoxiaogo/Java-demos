package io.github.yexiaoxiaogo.HelloWorld;

public class InstanceCounter {

	private static int numInstances = 0;
	
	protected static int getCount(){
		return numInstances;
	}
	
	private static void addInstance() {
		numInstances++;
	}
	
	InstanceCounter() {
		// TODO Auto-generated constructor stub
		InstanceCounter.addInstance();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("starting with "+ InstanceCounter.getCount()+" instances");
		for(int i = 0;i<500;i++){
			new InstanceCounter();
		}
		System.out.println("created "+InstanceCounter.getCount()+" instances");

	}

}
