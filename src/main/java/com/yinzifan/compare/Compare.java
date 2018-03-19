package com.yinzifan.compare;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import com.yinzifan.entity.Person;

/**
 * @author yinzf2 2018/03/19 17:43:25
 */
public class Compare {
    String diff(Object newObj, Object oldObj, String... ignoreProperties) throws NoSuchMethodException, SecurityException {
        Class<? extends Object> clz1 = newObj.getClass();
        Class<? extends Object> clz2 = newObj.getClass();
        String clazzName1 = clz1.getName();
        String clazzName2 = clz2.getName();
        if(!clazzName1.equals(clazzName2)){
            throw new RuntimeException("cannot diff "+clazzName1+" with "+ clazzName2);
        }
        Field[] field1 = clz1.getDeclaredFields();
        for (int i = 0; i < field1.length; i++) {
            Field field = field1[i];
            String fieldName = field.getName();
            if (Arrays.binarySearch(ignoreProperties, fieldName) != -1) {
//                clz1.getDeclaredMethod("get" + );
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		
		
	}
}
