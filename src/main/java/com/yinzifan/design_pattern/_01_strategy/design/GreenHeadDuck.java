package com.yinzifan.design_pattern._01_strategy.design;

public class GreenHeadDuck extends Duck {
    
    public GreenHeadDuck() {
        mFlyBehavior = new GoodFlyBehavior();
        mQuackBehavior = new GaGaQuackBehavior();
    }
    
    @Override
    public void display() {
        mFlyBehavior.fly();
        mQuackBehavior.quack();
        System.out.println("GreenHeadDuck.display()");
    }
}
