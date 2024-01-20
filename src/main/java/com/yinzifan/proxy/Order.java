package com.yinzifan.proxy;

public class Order implements IOrder {
    @Override
    public void pay() {
        System.out.println("pay...");
    }

    @Override
    public void show() {
        System.out.println("show...");
    }
}
