package com.yinzifan.enumDemo;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumDemo {

    private final static Logger LOGGER = LoggerFactory.getLogger(EnumDemo.class);
    public static void main(String[] args) throws UnsupportedEncodingException{
        //直接引用
        Day day =Day.WEDNESDAY;
        LOGGER.info(day.ordinal() + "");
        LOGGER.info(day.toString() + "");
        Day[] days = Day.values();
        for(Day d : days) {
            LOGGER.info(d.toString());
        }
    }
}