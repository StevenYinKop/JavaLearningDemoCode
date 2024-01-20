package com.yinzifan.proxy;

import org.junit.Test;

public class ProxyExampleTest {
    @Test
    public void test_proxy() throws Exception {
        IOrder order = Aspect.getProxy(
                Order.class,
                TimeUsageAspect.class.getName()
        );
        order.pay();
        order.show();
    }
}
