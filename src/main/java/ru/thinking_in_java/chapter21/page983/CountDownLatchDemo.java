package ru.thinking_in_java.chapter21.page983;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    static final int SIZE = 100;

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();


        for (int i = 0; i < 10; i++) {
            exec.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new TaskPosition(latch));
        }

        System.out.println("Launched all tasks");
        exec.shutdown();

    }

}
