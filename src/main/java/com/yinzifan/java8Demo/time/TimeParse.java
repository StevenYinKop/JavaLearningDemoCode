package com.yinzifan.java8Demo.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author yinzf2
 * 2018/06/13	9:06:29
 */
public class TimeParse {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd").withZone(ZoneId.systemDefault());
    public static void main(String[] args) {
        LocalDate parse = LocalDate.parse("1995/07/05", formatter);
        System.out.println(Date.from(parse.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }
    
}
