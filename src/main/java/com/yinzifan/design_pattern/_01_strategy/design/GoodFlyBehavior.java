package com.yinzifan.design_pattern._01_strategy.design;

/**
 * @author yinzf2
 * 2018/07/03	19:18:44
 */
public class GoodFlyBehavior implements FlyBehavior {
    
    @Override
    public void fly() {
        System.out.println("GoodFlyBehavior.fly()");
    }
    
}
