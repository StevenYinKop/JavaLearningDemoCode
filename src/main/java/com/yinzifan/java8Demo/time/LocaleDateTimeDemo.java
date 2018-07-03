package com.yinzifan.java8Demo.time;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

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
    
    @Test
    public void testFormat() throws Exception {
        LocalDate date = LocalDate.parse("2018/05/17", new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy/MM/dd")).toFormatter());
        System.out.println(date);
    }
    
    @Test
    public void testTimestampEquals() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp1 = Timestamp.valueOf(localDateTime);
        Timestamp timestamp2 = Timestamp.valueOf(localDateTime);
        System.out.println(timestamp1 == timestamp2);
    }
    
}
