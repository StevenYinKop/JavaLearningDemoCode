package cc.stevenyin.multithread.basic.threadlocal;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest {
    private static final ThreadLocal<Foo> LOCAL_FOO = new ThreadLocal<>();

    public static void main(String[] args) {
        // 调度器对象
        // ExecutorService用于管理线程池
//        ExecutorService executorService = Executors.newCachedThreadPool();
        // 可缓存线程池的特点是: 无限大,如果线程池没有可用的线程则创建,有空闲的则使用
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 定长线程池的特点是: 固定线程总数, 空闲线程用于执行任务, 如果线程都在使用,后续任务处于等待状态, 在线程池中的线程执行完任务后,再执行后续的任务
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newScheduledThreadPool(5);
        // 可调度线程池
        for (int i = 1; i <= 5; i++) {
            executorService.execute(() -> {
                if (LOCAL_FOO.get() == null) {
                    LOCAL_FOO.set(new Foo());
                }
                System.out.println("初始本地值: " + LOCAL_FOO.get());
                for (int j = 0; j < 10; j++) {
                    Foo foo = LOCAL_FOO.get();
                    foo.setBar(foo.getBar() + 1);
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("累加10次后的值: " + LOCAL_FOO.get());
                LOCAL_FOO.remove();
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
}
