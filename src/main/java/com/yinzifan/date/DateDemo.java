package com.yinzifan.date;

import java.util.Date;

/**
 * @author yinzf2
 * 2018/07/02	16:07:36
 */
public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        
        Date date2 = new Date(-date.getTime()/1000);
        System.out.println(date2);
    }
}
