package com.yinzifan.compare;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author yinzf2
 * 2018/05/16	13:53:51
 */
public class StringSort {
    public static void main(String[] args) {
       Set<SortInfo> set = new TreeSet<>(new Comparator<SortInfo>() {
        @Override
        public int compare(SortInfo o1, SortInfo o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });
       set.add(new SortInfo(1, "1"));
       set.add(new SortInfo(1, "2"));
       set.add(new SortInfo(1, "11"));
       set.add(new SortInfo(1, "3"));
       set.add(new SortInfo(1, "32"));
       set.add(new SortInfo(1, "23"));
       set.add(new SortInfo(1, "4"));
       set.add(new SortInfo(1, "12"));
       set.add(new SortInfo(1, "13"));
       set.add(new SortInfo(1, "24"));
       set.add(new SortInfo(1, "5"));
       set.add(new SortInfo(1, "41"));
       set.forEach(System.out::println);
        
    }
}

class SortInfo {
    String name;
    Integer age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     * @param name
     * @param age
     */
    public SortInfo(Integer age, String name) {
        super();
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "SortInfo [name=" + name + ", \nage=" + age + "]";
    }
}