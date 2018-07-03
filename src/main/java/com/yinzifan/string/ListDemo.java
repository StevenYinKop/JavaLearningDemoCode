package com.yinzifan.string;

/**
 * @author yinzf2
 * 2018/05/17	14:31:39
 */
public class ListDemo {
    
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isInteger("123"));
        System.out.println(isInteger("1abc"));
        System.out.println(isInteger("a1"));
        System.out.println(isInteger("A2354"));
        System.out.println(isInteger("__qa$12"));
    }
            
}
