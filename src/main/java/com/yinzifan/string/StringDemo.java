package com.yinzifan.string;

import java.util.Arrays;

/**
 * @author yinzf2
 * 2018/05/11	13:49:47
 */
public class StringDemo {
//    public static void main(String[] args) {
//        String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s3 = "Program";
//        String s4 = "ming";
//        String s5 = "Program" + "ming";
//        String s6 = s3 + s4;
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s5);
//        System.out.println(s1 == s6);
//        System.out.println(s1 == s6.intern());
//        System.out.println(s2 == s2.intern());
//    }
    public static void main(String[] args) {  
        String a = "Programming";  
        String b = new String("Programming");  
        String c = "Program" + "ming";  
          
        System.out.println(a == b);  
        System.out.println(a == c);  
        System.out.println(a.equals(b));  
        System.out.println(a.equals(c));  
        System.out.println(a.intern() == b.intern());  
    }  
    
}
