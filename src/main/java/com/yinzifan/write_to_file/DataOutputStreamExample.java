package com.yinzifan.write_to_file;

import static org.junit.Assert.assertEquals;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class DataOutputStreamExample {

    @Test
    public void givenWritingToFile_whenUsingDataOutputStream_thenCorrect() throws IOException {
        String value = "Hello";
        FileOutputStream fos = new FileOutputStream("DataOutputStreamExample.txt");
        DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
        outStream.writeUTF(value);
        outStream.close();
        // verify the results
        String result;
        FileInputStream fis = new FileInputStream("DataOutputStreamExample.txt");
        DataInputStream reader = new DataInputStream(fis);
        result = reader.readUTF();
        reader.close();
        assertEquals(value, result);
    }
}
