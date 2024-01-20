package com.yinzifan.proxy;

public class TimeUsageAspect implements Aspect {

    long start;

    @Override
    public void before() {
        start = System.currentTimeMillis();
    }

    @Override
    public void after() {
        long end = System.currentTimeMillis();
        System.out.format("time usage: %dms \n", end - start);
    }
}
