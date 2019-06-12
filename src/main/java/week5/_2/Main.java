package week5._2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Book b1 = new Book(1, "高性能MySQL", 128.0, "电子工业出版社");
		Book b2 = new Book(2, "亿级流量网站架构核心技术", 83.1, "电子工业出版社");
		Book b3 = new Book(3, "Spring Data JPA从入门到精通", 59.0, "清华大学出版社");
		Book b4 = new Book(4, "Java EE互联网轻量级框架整合开发 SSM框架（Spring MVC+Spring+MyBatis）和Redis实现", 119.0, "电子工业出版社");
		Book b5 = new Book(5, "算法(第4版) [Algorithms Fourth Edition]", 99.0, "人民邮电出版社");
		Book b6 = new Book(6, "Spring实战（第4版）", 89.0, "人民邮电出版社");
		List<Book> books = new ArrayList<>();
		Map<Integer, Book> map = new HashMap<>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		books.add(b5);
		books.add(b6);
		System.out.println("遍历List: ");
		for (Book book : books) {
			System.out.println(book);
		}
		map.put(b1.getBookId(), b1);
		map.put(b2.getBookId(), b2);
		map.put(b3.getBookId(), b3);
		map.put(b4.getBookId(), b4);
		map.put(b5.getBookId(), b5);
		map.put(b6.getBookId(), b6);
		System.out.println("遍历Map: ");
		map.forEach((id, book) -> {
			System.out.println(book);
		});
		
		
	}
}
