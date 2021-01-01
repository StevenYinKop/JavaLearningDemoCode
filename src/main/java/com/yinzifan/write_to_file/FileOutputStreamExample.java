package com.yinzifan.write_to_file;

import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class FileOutputStreamExample {
    @Test
    public void givenWritingStringToFile_whenUsingFileOutputStream_thenCorrect() throws IOException {
        String str = "Hello";
        FileOutputStream outputStream = new FileOutputStream("FileOutputStreamExample.txt");
        byte[] strToBytes = str.getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
    }
}
