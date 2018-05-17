package com.yinzifan.java8Demo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.yinzifan.entity.Person;

/**
 * @author yinzf2
 * 2018/04/28	10:09:02
 */
public class Reduce {
    public static void main(String[] args) {
        Person person0 = new Person("p1", 23, "23");
        Person person1 = new Person("p2", 24, " 24");
        Person person2 = new Person("p3", 25, " 25");
        Person person3 = new Person("p4", 26, " 26");
        Person person4 = new Person("p5", 27, " 27");
        Person person5 = new Person("p6", 28, " 28");
        List<Person> persons = new ArrayList<>();
        persons.add(person0);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        System.out.println(persons.stream().map(Person::getName).collect(Collectors.joining( "," )));//reduce(",", String::concat));
    }    
}
