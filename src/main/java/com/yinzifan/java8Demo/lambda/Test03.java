package com.yinzifan.java8Demo.lambda;

import org.junit.Test;

/**
 * @author yinzf2
 * 2018/04/19	16:41:23
 */
public class Test03 {

    /**
     * 
     */
    public Test03(Test01 t) {
        super();
        t.test01("");
    }
    public Test03(Test02 t) {
        super();
        Object o = new Object();
        t.test02(1);
    }
    
    
    
    @Test
    public void test() throws Exception {
        Test03 test1 = new Test03((String x) -> {
                
            }
        );
    }
}
