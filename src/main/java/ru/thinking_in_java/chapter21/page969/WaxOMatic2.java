package ru.thinking_in_java.chapter21.page969;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic2 {

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }

}
