package com.yinzifan.java8Demo.lambda;
/**
 * @author Cin
 * @time 2018/01/18 22:14:53 方法引用: 如果Lambda表达式中有方法已经实现了,
 *       我们可以使用"方法引用"(可以理解为是Lambda表达式的另外一种表现形式)
 * 
 *       主要有三种语法格式: 对象::实例方法名 类::静态方法名 类::实例方法名
 */

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.yinzifan.entity.Person;

public class LambdaDemo06 {

	@Test
	public void test1_0() throws Exception {
		// 对象::实例方法名
		Consumer<String> consumer = x -> System.out.println(x); // System.out已经实现了println这个方法
		PrintStream ps = System.out;
		consumer.accept("consumer->x");
		Consumer<String> consumer2 = ps::println;
		consumer2.accept("consumer2->x");
		// 注意: 如果Lambda体中的功能已经有方法实现了, 就可以使用方法引用的功能;
		// 此时: 函数接口的方法返回值类型和参数要和已经实现的方法的参数和返回值类型匹配
	}

	@Test
	public void test1_1() throws Exception {
		Person person = new Person();
		person.setName("person->name");
		Supplier<String> supplier = () -> person.getName();
		String string = supplier.get();
		System.out.println("supplier.get(): " + string); // 输出 person->name
		// 这里Lambda体中的内容是person.getName(), 这个方法在person这个对象中已经实现了, 就是getName这个方法
		// 所以可以写成下面的形式:
		Supplier<String> supplier2 = person::getName;
		System.out.println("supplier2.get(): " + supplier2.get());
	}

	@Test
	public void test2_0() throws Exception {
		Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);

		System.out.println(comparator.compare(1, 2));
		Comparator<Integer> comparator2 = Integer::compare;
		System.out.println(comparator2.compare(1, 2));
	}

	@Test
	public void test3() throws Exception {
		// 比較兩個字符串是否相同, 返回boolean值
		BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equals(s2);
		System.out.println(biPredicate.test("yinzf2", "yinzf2"));
		BiPredicate<String, String> biPredicate2 = String::equals; // 如果写成这种格式,
																	// 不能直接看出两个泛型参数的关系,
		// 此时Java默认认为第一个泛型参数是方法的调用者, 第二个泛型参数是这个方法的参数
		System.out.println(biPredicate2.test("yinzf2", "yinzf2"));
	}

	@Test
	public void test4() throws Exception {
		// 构造器引用
		// 可以使用Supplier实现创建对象的功能
		Supplier<Person> supplier = () -> new Person();
		System.out.println("()->new Person()  " + supplier.get());
		Supplier<Person> supplier2 = Person::new;
		// 构造器的参数列表应该和接口中抽象方法的参数列表匹配, 所以这个表达式调用的是空参的构造方法
		System.out.println("Person::new  " + supplier2.get()); 
	}

	@Test
	public void test5() throws Exception {
		Function<Integer, Person> function = (x)->new Person();
		System.out.println("(x)->new Person()  " + function.apply(20));
		Function<Integer, Person> function2 = Person::new;
		// 使用Function定义了一个Integer类型的传入参数, 此时调用构造则会使用Person的Person(Integer)的构造
		System.out.println("Person::new  " + function2.apply(20));
	}
	
	@Test
	public void test6() throws Exception {
		Function<Integer, String[]> function = x->new String[x];
		System.out.println(function.apply(10).length);
		Function<Integer, String[]> function2 = String[]::new;
		System.out.println(function2.apply(20).length);
		
	}
}
