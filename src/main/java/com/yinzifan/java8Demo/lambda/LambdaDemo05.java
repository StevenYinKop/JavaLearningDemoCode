package com.yinzifan.java8Demo.lambda;
/**
 * @author Cin
 * @time 2018/01/18 20:50:25 
 * Java8 内置的四大核心函数接口 
 * Consumer<T>: 消费型接口, 
 * 		void accept(T, t); 
 * Supplier<T>: 供给型接口,
 *  	T get(); 
 * Function<T, R>: 函数型接口, 
 *  	R apply(T t);
 * Predicate<T>: 断言型接口, 
 * 		boolean test(T t);
 * 
 * 其他接口: 
 * 		BiFunction<T, U, R> : 参数类型:T, U ,返回: R
 * 		UnaryOperator<T>  : Function的子接口: 参数: T, 返回值T
 * 		BinaryOperator<T>  : BiFunction的子接口: 参数类型: T, T 返回值T
 * 		BiConsumer<T, U>  : 参数类型T, U, 返回值: void
 * 
 * 		ToIntFunction<T>   :  参数类型T, 返回值 int
 * 		ToLongFunction<T>   :  参数类型T, 返回值 long
 * 		ToDoubleFunction<T>   :  参数类型T, 返回值 double
 * 
 * 		IntFunction<R>: 参数类型: int ,返回值 R
 * 		LongFunction<R>: 参数类型: long ,返回值 R
 * 		DoubleFunction	<R>: 参数类型: double ,返回值 R
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;
public class LambdaDemo05 {
	// Consumer<T>: 消费型接口
	@Test
	public void testConsumer() throws Exception {
		spendMoney(100, m -> System.out.println("spend $" + m));
	}

	public void spendMoney(double money, Consumer<Double> consumer) {
		consumer.accept(money);
	}

	// Supplier<T>: 供给型接口,
	@Test
	public void testSupplier() throws Exception {
		List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			list.add(supplier.get());
		}
		return list;
	}

	// Function<T, R>: 函数型接口,
	@Test
	public void testFunction() throws Exception {
		String string = "\t\t\t 11 RETGYUIKOP     ";
		String trimString = stringUtils(string, str -> str.trim());
		System.out.println(trimString);
		String subString = stringUtils(trimString, str -> str.substring(0, 2));
		System.out.println(subString);
	}

	public String stringUtils(String string, Function<String, String> function) {
		return function.apply(string);
	}

	// Predicate<T>: 断言型接口,
	@Test
	public void testPredicate() throws Exception {
		List<String> list = getValityString(Arrays.asList("yinzf2", "11111", "testtest", "hellow"),
				x -> x.equals("yinzf2"));
		for (String string : list) {
			System.out.println(string);
		}
	}

	public List<String> getValityString(List<String> list, Predicate<String> predicate) {
		List<String> result = new ArrayList<>();
		for (String string : list) {
			if (predicate.test(string)) {
				result.add(string);
			}
		}
		return result;
	}
}
