package com.yinzifan.java8Demo.defaultmethod;
/**
* @author Cin
* @time 2018/01/01 21:36:50
*/
public class Frog implements ILandAnimal, IWaterAnimal{

	@Override
	public void swim() {
		System.out.println("Frog.swim()");
	}

	@Override
	public void run() {
		System.out.println("Frog.run()");
	}

	public static void main(String[] args) {
		Frog frog = new Frog();
		frog.breathInAir();
		frog.breathInWater();
		frog.swim();
		frog.run();
		ILandAnimal.count();
	}
}
