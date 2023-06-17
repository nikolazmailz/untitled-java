package ru.java_philosophy.chapter21.page955;


import java.util.concurrent.TimeUnit;

public class InterruptedIdiom {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("t.interrupt()");
        t.interrupt();
    }
}
