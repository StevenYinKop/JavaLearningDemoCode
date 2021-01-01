package com.yinzifan.write_to_file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class BufferedWriterExample {

    @Test
    public void whenWriteStringUsingBufferedWritter_thenCorrect() 
      throws IOException {
        String str = "Hello";
        BufferedWriter writer = new BufferedWriter(new FileWriter("BufferedWriterExample.txt"));
        writer.write(str);
        writer.close();
    }
    @Test
    public void whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo() 
      throws IOException {
        String str = "World";
        BufferedWriter writer = new BufferedWriter(new FileWriter("BufferedWriterExample.txt", true));
        writer.append(' ');
        writer.append(str);
        
        writer.close();
    }
}
