package com.yinzifan.write_to_file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

import org.junit.Test;

public class LockFileExample {
    @Test
    public void whenTryToLockFile_thenItShouldBeLocked() throws IOException {
        RandomAccessFile stream = new RandomAccessFile("LockFileExample.txt", "rw");
        FileChannel channel = stream.getChannel();
        FileLock lock = null;
        try {
            lock = channel.tryLock();
        } catch (final OverlappingFileLockException e) {
            stream.close();
            channel.close();
        }
        stream.writeChars("test lock");
        lock.release();
        stream.close();
        channel.close();
    }
}
