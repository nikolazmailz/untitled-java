package ru.thinking_in_java.chapter21.page948;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class WaitImpl implements Runnable {

    String name;

    WaitImpl(String s) {
        name = s;
    }

    @Override
    public void run() {

        synchronized (this) {
            try {
                System.out.println(name);
                System.out.println("I'm is run");
                this.wait();
                System.out.println("I'm is off");
            } catch (InterruptedException e) {
                System.out.println("WaitImpl catch");
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new WaitImpl("1"));
        t.start();
        System.out.println("s.start()");
        TimeUnit.SECONDS.sleep(10);
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());

    }
}
