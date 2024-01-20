package com.yinzifan.buffer;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BufferExamples {
    @Test
    public void test_chinese() {
        String raw = "阿姆达尔定律（英语：Amdahl's law，Amdahl's argument），一个计算机科学界的经验法则，因吉恩·阿姆达尔而得名。它代表了处理器并行运算之后效率提升的能力。";
        Charset charset = StandardCharsets.UTF_8;
        byte[] bytes = charset.encode(raw).array();
        byte[] bytes2 = Arrays.copyOfRange(bytes, 0, 11);

        ByteBuffer bbuf = ByteBuffer.allocate(12);
        CharBuffer cbuf = CharBuffer.allocate(12);

        bbuf.put(bytes2);
        // 读取之前先flip
        bbuf.flip();

        charset.newDecoder().decode(bbuf, cbuf, true);

        cbuf.flip();
        char[] tmp = new char[cbuf.length()];
        if (cbuf.hasRemaining()) {
            cbuf.get(tmp);
            System.out.println(new String(tmp));
        }

        System.out.format("limit - pos = %d \n", bbuf.limit() - bbuf.position());

        byte[] rest = Arrays.copyOfRange(bbuf.array(), bbuf.position(), bbuf.limit());
        System.out.println(new String(rest));
        System.out.format("limit - pos = %d \n", bbuf.limit() - bbuf.position());
    }
}
