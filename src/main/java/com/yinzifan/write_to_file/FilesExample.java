package com.yinzifan.write_to_file;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class FilesExample {

    @Test
    public void givenUsingJava7_whenWritingToFile_thenCorrect() throws IOException {
        String str = "Hello";

        Path path = Paths.get("FilesExample.txt");
        byte[] strToBytes = str.getBytes();

        Files.write(path, strToBytes);

        String read = Files.readAllLines(path).get(0);
        assertEquals(str, read);
    }
}
