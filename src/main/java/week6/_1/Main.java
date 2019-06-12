package week6._1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		InputStream in = new FileInputStream("student.properties");
		Properties prop = new Properties();
		prop.load(in);
		String className = prop.getProperty("className");
		String id = prop.getProperty("id");
		String name = prop.getProperty("name");
		String age = prop.getProperty("age");
		Class<?> clz = Class.forName(className);
		Student student = (Student) clz.newInstance();
		student.setId(Integer.parseInt(id));
		student.setName(name);
		student.setAge(Integer.parseInt(age));
		System.out.println(student.toString());
	}
}
