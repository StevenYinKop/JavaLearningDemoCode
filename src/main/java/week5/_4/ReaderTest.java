package week5._4;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 使用字符流把1-100的100个数存入number.txt中
 */
public class ReaderTest {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("number.txt");
		for (int i = 1; i <= 100; i++) {
			fw.write(i + "\n");
		} 
		fw.close();
	}
}
