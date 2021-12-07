//package cc.stevenyin.multithread.basic.threadlocal;
//
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//public class ThreadUtil {
//    private static  final int MIXED_MAX = 128; // 最大线程数
//    private static final String MIXED_THREAD_AMOUNT = "mixed.thread.amount";
//    /**
//     * 空闲保活时限
//     */
//    private static final int KEEP_ALIVE_SECONDS = 30;
//    /**
//     * 有界队列size
//     */
//    private static final int QUEUE_SIZE = 128;
//
//
//    private static class MixedTargetThreadPoolLazyHolder {
//        private static final int max = (null != System.getProperty(MIXED_THREAD_AMOUNT)) ? Integer.parseInt(System.getProperty(MIXED_THREAD_AMOUNT)) : MIXED_MAX;
//        private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                max,
//                max,
//                KEEP_ALIVE_SECONDS,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(QUEUE_SIZE),
//        )
//    }
//}
