package com.yinzifan.design_pattern._01_strategy.traditional;
public abstract class Duck {

    public void Quack() { 
        System.out.println("~~gaga~~");
    }
    public abstract void display(); 
    public void swim() {
        System.out.println("~~im swim~~"); }
    public void Fly() {
        System.out.println("~~im fly~~"); 
    }
}
