package com.yinzifan.java8Demo.stream;
/**
* @author Cin
* @time 2018/01/20 14:18:32
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.yinzifan.entity.Person;

public class StreamQ {
    /**
     * 给定一个数字列表, 返回一个由每个数平方构成的列表 如: [1,2,3,4,5] 返回 [1,4,9,16,25]
     */
    public List<Integer> getPow(List<Integer> list) {
        return list.stream().map(x -> x * x).collect(Collectors.toList());
    }
    
    @Test
    public void test01() throws Exception {
        System.out.println(getPow(Arrays.asList(1, 3, 5, 7, 9)));
    }
    
}
