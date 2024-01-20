package com.yinzifan.buffer;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;

public class WordCount {

    @Test
    public void generateWordFile() throws IOException {
        Random random = new Random();
        String filename = "word";
        FileOutputStream fout = new FileOutputStream(filename);
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e'};
        for (int i = 0; i < 1_000_000; i++) {
            for (int j = 0; j < 5; j++) {
                fout.write(chars[random.nextInt(5)]);
            }
        }
        fout.close();
    }

    @Test
    public void compare_with_single() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("word"));
        byte[] buf = new byte[4 * 1024];
        int len = 0;
        Map<String, Integer> total = new HashMap<>();
        long start = System.currentTimeMillis();
        while ((len = in.read(buf)) != -1) {
            byte[] bytes = Arrays.copyOfRange(buf, 0, len);
            String str = new String(bytes);
            Map<String, Integer> hashMap = countByString(str);
            hashMap.forEach((k, v) -> incKey(k, total, v));
        }
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start) + "ms");
        System.out.println(total.get("ababb"));
        System.out.println(total.size());
    }

    private HashMap<String, Integer> countByString(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            // 增加词频
            incKey(tokenizer.nextToken(), map, 1);
        }
        return map;
    }

    private void incKey(String key, Map<String, Integer> map, Integer n) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + n);
        } else {
            map.put(key, n);
        }
    }

    class CountTask implements Callable<HashMap<String, Integer>> {
        private final long start;
        private final long end;
        private final String filename;

        public CountTask(long start, long end, String filename) {
            this.start = start;
            this.end = end;
            this.filename = filename;
        }

        @Override
        public HashMap<String, Integer> call() throws Exception {
            Map<String, Integer> map = new HashMap<>();
            FileChannel channel = new RandomAccessFile(this.filename, "rw").getChannel();
            // Device -> Kernel Space -> User Space(buffer) -> Thread
            // load [start, end] into memory
            MappedByteBuffer mbuf = channel.map(
                    FileChannel.MapMode.READ_ONLY,
                    start,
                    end - start
            );
            return countByString(StandardCharsets.US_ASCII.decode(mbuf).toString());
        }

    }
}
