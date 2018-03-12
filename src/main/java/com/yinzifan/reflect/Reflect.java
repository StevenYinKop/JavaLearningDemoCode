package com.yinzifan.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author yinzf2 2018/03/12 14:34:43
 */
public class Reflect {
    
    public static void foo(Historicable modified) {
        Class<? extends Historicable> clazz = modified.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            if (m.getName().startsWith("get")) {
                System.out.println(m.getName());
            }
        }
    }
    public static void main(String[] args) {
        BugInfoEntity b = new BugInfoEntity();
        foo(b);
        
    }
}
