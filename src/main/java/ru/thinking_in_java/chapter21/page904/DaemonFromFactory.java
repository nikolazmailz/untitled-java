package ru.thinking_in_java.chapter21.page904;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(
            new DaemonThreadFactory()
        );
        for (int i=0; i<5; i++){
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All daemon started");
        TimeUnit.MILLISECONDS.sleep(175);

        ExecutorService exec2 = new DaemonThreadPoolExecutor();
        for (int i=0; i<5; i++){
            exec2.execute(new DaemonFromFactory());
        }
        System.out.println("All DaemonThreadPoolExecutor daemon started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
