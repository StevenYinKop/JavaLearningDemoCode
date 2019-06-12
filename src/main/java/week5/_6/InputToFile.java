package week5._6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 把控制台输入的内容 写入 到 a.txt文件中
 */
public class InputToFile {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("src\\main\\java\\week5\\_6\\result.txt");
		Scanner sc = new Scanner(System.in);
		while(true) {
			String nextLine = sc.nextLine();
			if (!"exit()".equals(nextLine)) {
				fw.write(nextLine + "\n");
				fw.flush();
			} else {
				break;
			}
		}
	}
}
