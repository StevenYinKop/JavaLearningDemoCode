package com.yinzifan.java8Demo.lambda;
/**
 * @author Cin
 * @time 2018/01/01 20:46:11
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LambdaDemo04 {

	@Test
	public void test1() throws Exception {
		Integer[] integers = new Integer[] { 1, 2, 3, 4, 4, 5, 3, 1, 8 };
		// Arrays.sort(integers, (x,y)->Integer.compare(x, y));
		// lambda表达式的方法引用 sort方法需要实现一个Comparator接口
		// Comparator接口是一个函数式接口,所以可以写成上面的形式
		// 但是上面的形式中, 我们调用了Integer中的compare方法, 我们将lambda表达式的参数(x,y)没有进行任何修改,
		// 直接传递给了Integer.compare(x,y)的方法,
		// 而Integer.compare(x,y)这个方法的返回值也是我们所需要的int值,
		// 这个时候上面的lambda表达式就可以简写成下面的形式了:
		// 这种化简的操作也称为 方法引用
		Arrays.sort(integers, Integer::compare);
		System.out.println(Arrays.toString(integers));
	}

	@Test
	public void test2() throws Exception {
		LambdaDemo04 l = new LambdaDemo04();
		Integer[] integers = new Integer[] { 1, 2, 3, 4, 4, 5, 3, 1, 8 };
		Arrays.sort(integers, l::compare);
		// Arrays.sort(integers, this::compare);
		System.out.println(Arrays.toString(integers));
	}

	public int compare(int x, int y) {
		return Integer.compare(x, y);
	}

	@Test
	public void test3() throws Exception {
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 1, 5, 2, 3);
		// list.forEach(x->System.out.println(x));
		list.forEach(System.out::println);
	}

	@Test
	public void test4() throws Exception {
		// 在上述例子中 Arrays.asList() 默认返回的是一个ArrayList, 可是如果我想要LinkedList就没有办法直接获得.
		// 我们可以自己写一个方法将Class作为参数传递进去, 并且返回相应的Instance,
		// 但是在lambda中可以使用构造方法引用的方式显得更加优雅
		// 写法: 类::new
		List<Integer> list = asList(LinkedList::new, 1, 25, 17, 20, 35, 51, 67, 64, 23);
		list.forEach(System.out::println);
		System.out.println(list.getClass());
	}

	public <T> List<T> asList(IMyAsList<List<T>> myAsList, @SuppressWarnings("unchecked") T... a) {
		List<T> list = myAsList.create();
		for (T t : a)
			list.add(t);
		return list;
	}
}