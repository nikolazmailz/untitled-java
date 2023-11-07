package ru.check.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicImpl {

    private static int NUM = 5;
    ExecutorService executorService = Executors.newCachedThreadPool();

    CyclicImpl(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM,
                new Runnable(){
                    @Override
                    public void run() {
                        System.out.println("CyclicImpl");
                    }
                });

        for (int i = 0; i < NUM; i++) {
            executorService.execute(new RunnableClass(cyclicBarrier));
        }

    }

    public static void main(String[] args) throws InterruptedException {
        CyclicImpl c = new CyclicImpl();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("shutdownNow");
        c.executorService.shutdownNow();
    }

}
