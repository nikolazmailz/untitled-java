package ru.interview.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution {

    private static volatile int counter1 = 0;
    private static volatile int counter2 = 0;

    public static void main(String[] args) {
        try {
            new Solution().method();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int hundred = 100;

    public void method() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(hundred);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < hundred; i++) {
            executor.submit(() -> {
                // Увеличение счетчика
                synchronized (latch){
                    counter1++;
                    counter2++;
                }

                // Имитация длительной операции
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " выполняется " + System.nanoTime());
                    System.out.println(counter1 + " counter1");
                    System.out.println(counter2 + " counter2");
                    latch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }


        latch.await();

        executor.shutdown();

        System.out.println(counter1);
        System.out.println(counter2);
    }

}
