package com.yinzifan.string;
class Outer {

    class Inner {}

    public static void foo() { new Outer().new Inner(); }

    public void bar() { new Inner(); }

    public static void main(String[] args) {
        new Outer().new Inner();
    }
}