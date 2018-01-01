package com.yinzifan.java8Demo.defaultmethod;
/**
* @author Cin
* @time 2018/01/01 21:34:23
*/
public interface IWaterAnimal {

	void swim();
	
	default void breathInWater() {
		System.out.println("IWaterAnimal.breathInWater()");
	}
}
