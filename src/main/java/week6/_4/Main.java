package week6._4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		InputStream in = new FileInputStream("person.properties");
		Properties prop = new Properties();
		prop.load(in);
		String className = prop.getProperty("className");
		String methodName = prop.getProperty("method");
		Class<?> clz = Class.forName(className);
		Method method = clz.getMethod(methodName);
		method.invoke(clz.newInstance());
	}
}
