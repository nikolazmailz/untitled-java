package ru.java_philosophy.chapter21.page902;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable{

    private int countDown = 5;
    private volatile double d;
    private static volatile int ii = 0;
    private int priority;

    public SimplePriorities(int priority){
        this.priority = priority;
    }

    public String toString(){
        return Thread.currentThread() + ": " + countDown +
            " priority: " + Thread.currentThread().getPriority()
            + " d: " + d
            + "| ii: " + ii;
    }

    public void run(){
        Thread.currentThread().setPriority(priority);
        while (true){
            for (int i = 1; i < 100_000; i++){
                d += (Math.PI + Math.E) / (double) i;
                if(i % 1000 == 0){
                    Thread.yield();
                }
            }
            ii++;
            System.out.println(this);
            if(--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
