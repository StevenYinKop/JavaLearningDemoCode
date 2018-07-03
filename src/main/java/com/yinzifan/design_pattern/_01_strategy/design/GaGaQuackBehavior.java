package com.yinzifan.design_pattern._01_strategy.design;

/**
 * @author yinzf2
 * 2018/07/03	19:18:51
 */
public class GaGaQuackBehavior implements QuackBehavior {
    
    @Override
    public void quack() {
        System.out.println("GaGaQuackBehavior.quack()");
    }
    
}
