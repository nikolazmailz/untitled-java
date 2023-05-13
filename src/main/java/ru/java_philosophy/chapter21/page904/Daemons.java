package ru.java_philosophy.chapter21.page904;

import java.util.concurrent.TimeUnit;

public class Daemons {

    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();

        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1);
    }
}
