package com.yinzifan.design_pattern._01_strategy.design;

public abstract class Duck {
    FlyBehavior mFlyBehavior;
    QuackBehavior mQuackBehavior;
    
    public Duck() {
    }
    
    public void Fly() {
        mFlyBehavior.fly();
    }
    
    public void Quack() {
        mQuackBehavior.quack();
    }
    
    public abstract void display();
}

