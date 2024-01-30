package com.yinzifan.eventdriven;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ProducerCustomerModel {
    private static final int MAX = 20;


    ReentrantLock lock = new ReentrantLock();

    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();

    LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        ProducerCustomerModel model = new ProducerCustomerModel();
        IntStream.range(0, 100)
                .forEach(i -> {
                    new Thread(() -> {
                        while (true) {
                            try {
                                model.produce();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }).start();
                });
        new Thread(() -> {
            while (true) {
                try {
                    model.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public int readData() throws InterruptedException {
        var time = (long) (Math.random() * 500);
        Thread.sleep(time);
        return (int) Math.floor(time);
    }

    public void produce() throws InterruptedException {
        lock.lock();
        if (queue.size() == MAX) {
            full.await();
            return;
        }
        int data = readData();
        if (queue.size() == 1) {
            empty.signalAll();
        }
        queue.add(data);
        lock.unlock();
    }

    public void consume() throws InterruptedException {
        lock.lock();
        if (queue.isEmpty()) {
            empty.await();
            return;
        }
        int data = queue.remove();
        if (queue.size() == MAX - 1) {
            full.signalAll();
        }
        System.out.println("Current queue size: " + queue.size());
        data *= 100;
        System.out.println("Data after consuming: " + data);
        lock.unlock();
    }

}
