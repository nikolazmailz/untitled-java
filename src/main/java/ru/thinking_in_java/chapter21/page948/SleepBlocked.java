package ru.thinking_in_java.chapter21.page948;

import java.util.concurrent.TimeUnit;

public class SleepBlocked implements Runnable, Cloneable{

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
