package com.yinzifan.java8Demo.stream;
/**
* @author Cin
* @time 2018/01/18 22:15:24
* Stream API
* 	操作步骤: 
* 		1. 创建Stream
* 		2. 一系列流水线式的中间操作
*       3. 终止操作
*   Stream 是Java8 中处理集合的关键操作可以执行复杂的查找,过滤,映射等操作,
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.yinzifan.entity.Person;

public class StreamDemo01 {
	@Test
	public void test1() throws Exception {
		// 创建一个流: 
		// 1 Collection接口中的stream()和parallelStream方法
//		List<String> list = new ArrayList<>();
//		Stream<String> stream = list.stream();
//		Stream<String> parallelStream = list.parallelStream();
		// 2 通过Arrays.stream()方法来创建一个流
//		Stream<Integer> arrayStream = Arrays.stream(new Integer[10]);
//		3 通过Stream类的静态方法of()来创建
//		Stream<Integer> ofStream = Stream.of(1,2,3,4,5,6);
	}
	List<Person> list = Arrays.asList(
			new Person("tom", 12, "USA"),
			new Person("zhangsan", 23, "CN"),
			new Person("sakura", 14, "JP"),
			new Person("bruce", 10, "UK"),
			new Person("monika", 25, "GR")
			);
	/*
	  筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个(也就是说全部被扔掉了)，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */
	@Test
	public void testFilter() throws Exception {
		List<Person> resultList=  new ArrayList<>();
		list.stream().filter((x) -> x.getAge()>18).forEach(resultList::add);
		System.out.println(resultList);
	}

	@Test
	public void testLimit() throws Exception {
		List<Person> resultList = new ArrayList<>();
		list.stream().filter(x -> x.getName().contains("a")).limit(1).forEach(resultList::add); // limit(1)只会得到第一个满足条件的元素
		System.out.println(resultList);
	}
	@Test
	public void testSkip() throws Exception {
		List<Person> resultList = new ArrayList<>();
		list.stream().filter(x -> x.getName().contains("a")).skip(1).forEach(resultList::add); // skip(1)会跳过第一个满足条件的元素, 得到剩下的元素, 如果全部被跳过了则返回一个空流
		System.out.println(resultList);
	}
	@Test
	public void testDistinct() throws Exception {
		List<Integer> list=  Arrays.asList(1,2,3,4,5,6,6,5,4,3,3,2);
		List<Integer> resultList=  new ArrayList<>();
		list.stream().distinct().forEach(resultList::add); // 根据hashCode和equals方法去除重复元素 
		System.out.println(resultList);
	}
	@Test
	public void testMap() throws Exception {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,5,4,3,2,7,6,5,4,2);
		list.stream().map(x->x+2).forEach(System.out::println);
	}
	
}
