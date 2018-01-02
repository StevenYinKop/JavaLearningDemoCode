package com.yinzifan.java8Demo.defaultmethod;
/**
* @author Cin
* @time 2018/01/01 21:36:11
*/
public interface ILandAnimal {

	void run();
	
	static void count () {
		System.out.println("ILandAnimal.count()");
	}
	
	default void breathInAir() {
		System.out.println("ILandAnimal.breathInAir()");
	}
	default void eat() {
	    System.out.println("ILandAnimal.eat()");
	}
	
}
