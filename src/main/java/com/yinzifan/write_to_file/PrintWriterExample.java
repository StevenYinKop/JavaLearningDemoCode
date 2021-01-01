package com.yinzifan.write_to_file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

public class PrintWriterExample {
    @Test
    public void givenWritingStringToFile_whenUsingPrintWriter_thenCorrect() 
      throws IOException {
        FileWriter fileWriter = new FileWriter("PrintWriterExample.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("Some String");
        printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
        printWriter.close();
    }
}
