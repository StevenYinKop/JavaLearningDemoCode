package com.yinzifan.java8Demo.time;

import java.time.LocalDateTime;

import org.junit.Test;

/**
 * @author yinzf2
 * 2018/05/17	11:04:19
 */
public class LocaleDateTimeDemo {
    @Test
    public void testLocalDateTime() throws Exception {
        LocalDateTime time = LocalDateTime.now();
        int year = time.getYear();
        int month = time.getMonthValue();
        int day = time.getDayOfMonth();
        System.out.println(String.format("%d/%d/%d", year, month, day));
    }
    
    
}
