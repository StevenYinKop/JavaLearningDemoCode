package week5._5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 把 img.jpg图片 读取出来 写入到 imgnew.jpg中
 *
 */
public class ImgCopy {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src\\main\\java\\week5\\_5\\img.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis);	
		FileOutputStream fos = new FileOutputStream("src\\main\\java\\week5\\_5\\imgnew.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(fos);		
		int b;
		while((b = bis.read()) != -1) {		
			bos.write(b);
		}
		bis.close();				
		bos.close();
	}
}
