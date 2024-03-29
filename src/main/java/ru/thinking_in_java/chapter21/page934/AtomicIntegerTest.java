package ru.thinking_in_java.chapter21.page934;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable {
    private AtomicInteger at = new AtomicInteger(0);
    public int getValue() { return at.get();}
    private void evenIncrement(){ at.addAndGet(2);}

    public void run(){
        while (true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(
            new TimerTask() {
                public void run() {
                    System.err.println("Aborting");
                    System.exit(0);
                }
            }, 500
        );
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        while (true){
            int val = ait.getValue();
            if(val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
