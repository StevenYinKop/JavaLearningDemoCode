package com.yinzifan.java8Demo.lambda;
/**
 * @author Cin
 * @time 2018/01/01 16:56:19
 */

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class LambdaDemo01 {

	class User {
		public String name;
		public int score;

		public User(String name, int score) {
			super();
			this.name = name;
			this.score = score;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", score=" + score + "]";
		}
	}

	@Test
	public void testOldUse() {
		User[] users = new User[] { new User("user1", 10), new User("user2", 30), new User("user3", 20), };
		Arrays.sort(users, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return Integer.compare(o1.score, o2.score);
			}
		});
		System.out.println(Arrays.toString(users));
	}

	@Test
	public void testOldUse2() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello lambda");
			}
		}).start();
	}

	@Test
	public void testNewUse() {
		User[] users = new User[] { new User("user1", 10), new User("user2", 30), new User("user3", 20), };
		// Arrays.sort(users, (User o1, User o2) -> {
		// return Integer.compare(o1.score, o2.score);
		// }
		// ); 第一步简化,
		Arrays.sort(users, (o1, o2) -> Integer.compare(o1.score, o2.score));
		System.out.println(Arrays.toString(users));
	}

	@Test
	public void testNewUse2() {
		new Thread(() -> System.out.println("hello lambda")).start();
	}

	@Test
	public void testNewUse3() {
		// Runnable runnable = new Runnable() {
		// public void run() {
		// System.out.println("hello lambda");
		// }
		// }; 该实现可以简化如下
		Runnable runnable = () -> System.out.println("hello lambda");
		new Thread(runnable).start();
	}
}
