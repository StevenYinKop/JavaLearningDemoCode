package cc.stevenyin.multithread.basic.threadlocal;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MultipleThreadLocalTest {
    private static final ThreadLocal<Foo> LOCAL_FOO = new ThreadLocal<>();
    private static final ThreadLocal<Foo2> LOCAL_FOO2 = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            executorService.execute(() -> {
                if (LOCAL_FOO.get() == null) {
                    LOCAL_FOO.set(new Foo());
                }
                System.out.println("初始本地值: " + LOCAL_FOO.get());
                if (LOCAL_FOO2.get() == null) {
                    LOCAL_FOO2.set(new Foo2());
                }
                System.out.println("初始本地值: " + LOCAL_FOO2.get());
                for (int j = 0; j < 10; j++) {
                    Foo foo = LOCAL_FOO.get();
                    Foo2 foo2 = LOCAL_FOO2.get();
                    foo.setBar(foo.getBar() + 1);
                    foo2.setBar(foo2.getBar() + 1);
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("累加10次后的值: LOCAL_FOO = " + LOCAL_FOO.get());
                System.out.println("累加10次后的值: LOCAL_FOO2 = " + LOCAL_FOO2.get());
                LOCAL_FOO.remove();
                LOCAL_FOO2.remove();
            });
        }
        executorService.shutdown();
    }

    @Data
    static class Foo {
        static final AtomicInteger AMOUNT = new AtomicInteger(0);
        int index = 0;
        int bar = 0;

        public Foo() {
            index = AMOUNT.incrementAndGet();
        }

        @Override
        public String toString() {
            return index + "Foo{" +
                    "@bar=" + bar +
                    '}';
        }
    }

    @Data
    static class Foo2 {
        static final AtomicInteger AMOUNT = new AtomicInteger(0);
        int index = 0;
        int bar = 0;

        public Foo2() {
            index = AMOUNT.incrementAndGet();
        }

        @Override
        public String toString() {
            return index + "Foo2{" +
                    "@bar=" + bar +
                    '}';
        }
    }
}
