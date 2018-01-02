package com.yinzifan.java8Demo.defaultmethod;

/**
 * @author Cin
 * @time 2018/01/01 21:36:50
 */
public class Frog extends Animal implements ILandAnimal, IWaterAnimal {
    
    @Override
    public void swim() {
        System.out.println("Frog.swim()");
    }
    
    @Override
    public void run() {
        System.out.println("Frog.run()");
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.yinzifan.java8Demo.defaultmethod.IWaterAnimal#eat()
     */
    @Override
    public void eat() {
        // TODO Auto-generated method stub
        IWaterAnimal.super.eat();
    }
    
    
    /*
     * (non-Javadoc)
     * 
     * @see com.yinzifan.java8Demo.defaultmethod.ILandAnimal#eat()
     */
    // @Override
    // public void eat() {
    // // TODO Auto-generated method stub
    // ILandAnimal.super.eat();
    // }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.yinzifan.java8Demo.defaultmethod.Animal#sleep()
     */
    @Override
    void sleep() {
        System.out.println("Frog.sleep()");
        // TODO Auto-generated method stub
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
