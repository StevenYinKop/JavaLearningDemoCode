package com.yinzifan.enumDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumDemo {

    private final static Logger LOGGER = LoggerFactory.getLogger(EnumDemo.class);
    public static void main(String[] args){
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