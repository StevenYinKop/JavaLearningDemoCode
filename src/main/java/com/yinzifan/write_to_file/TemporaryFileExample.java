package com.yinzifan.write_to_file;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TemporaryFileExample {

    @Test
    public void whenWriteToTmpFile_thenCorrect() throws IOException {
        String toWrite = "Hello";
        File tmpFile = File.createTempFile("test", ".tmp");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(toWrite);
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
        assertEquals(toWrite, reader.readLine());
        reader.close();
    }
}
