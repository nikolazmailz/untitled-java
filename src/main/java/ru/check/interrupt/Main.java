package ru.check.interrupt;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

//        Thread t = new Thread(new MyRunnable("1"));
//
//        System.out.println("t.start()");
//        t.start();


        Thread t2 = new Thread(new MyRunnable("2"));
//        long time2 = System.currentTimeMillis();
//        System.out.println("t.start()2");
        t2.start();
        t2.interrupt();
        TimeUnit.MILLISECONDS.sleep(10);
        System.out.println("exit sleep");
//        System.out.println("out2 " + (System.currentTimeMillis() - time2));

    }

}
