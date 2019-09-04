package com.yinzifan.design_pattern.principle.single_responsibility;

public class SingleResponsibility3 {
	public static void main(String[] args) {
		Vehicle2 vehicle = new Vehicle2();
		vehicle.runInWater("submarine");
		vehicle.runOnAir("plane");
		vehicle.run("motor");
	}
}

class Vehicle2 {
	public void runInWater(String vehicle) {
		System.out.println(vehicle + " is running in the water");
	}
	public void run(String vehicle) {
		System.out.println(vehicle + " is running on the road");
	}
	public void runOnAir(String vehicle) {
		System.out.println(vehicle + " is running on the air");
	}
}
