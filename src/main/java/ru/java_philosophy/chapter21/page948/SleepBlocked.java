package ru.java_philosophy.chapter21.page948;

import java.util.concurrent.TimeUnit;

public class SleepBlocked implements Runnable{

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}
