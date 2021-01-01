package com.yinzifan.write_to_file;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class FileChannelExample {

    @Test
    public void givenWritingToFile_whenUsingFileChannel_thenCorrect() throws IOException {
        RandomAccessFile stream = new RandomAccessFile("FileChannelExample.txt", "rw");
        FileChannel channel = stream.getChannel();
        String value = "Hello";
        byte[] strBytes = value.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
        buffer.put(strBytes);
        buffer.flip();
        channel.write(buffer);
        stream.close();
        channel.close();

        // verify
        RandomAccessFile reader = new RandomAccessFile("FileChannelExample.txt", "r");
        assertEquals(value, reader.readLine());
        reader.close();
    }
}
