package com.yinzifan.write_to_file;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

public class RandomAccessFileExample {

    private void writeToPosition(String filename, int data, long position) throws IOException {
        RandomAccessFile writer = new RandomAccessFile(filename, "rw");
        writer.seek(position);
        writer.writeInt(data);
        writer.close();
    }

    private int readFromPosition(String filename, long position) throws IOException {
        int result = 0;
        RandomAccessFile reader = new RandomAccessFile(filename, "r");
        reader.seek(position);
        result = reader.readInt();
        reader.close();
        return result;
    }

    @Test
    public void whenWritingToSpecificPositionInFile_thenCorrect() throws IOException {
        int data1 = 2014;
        int data2 = 1500;

        writeToPosition("RandomAccessFileExample.txt", data1, 4);
        assertEquals(data1, readFromPosition("RandomAccessFileExample.txt", 4));
        System.out.println(readFromPosition("RandomAccessFileExample.txt", 4));
        writeToPosition("RandomAccessFileExample.txt", data2, 4);
        assertEquals(data2, readFromPosition("RandomAccessFileExample.txt", 4));
        System.out.println(readFromPosition("RandomAccessFileExample.txt", 4));
    }
}
