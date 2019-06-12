package com.yinzifan.week3._1;

public class Feeder {
	private Animal animal;
	public Feeder(Animal animal) {
		this.animal = animal;
	}
	
	public void feed() {
		System.out.println("我是" + this.animal.getName() + ", " + this.animal.enjoy());
	}
	
	public static void main(String[] args) {
		Animal cat = new Cat("小猫1号");
		Animal dog = new Dog("小狗1号");
		Feeder feeder1 = new Feeder(cat);
		Feeder feeder2 = new Feeder(dog);
		feeder1.feed();
		feeder2.feed();
	}
}
