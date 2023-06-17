package ru.java_philosophy.chapter21.page969;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {

    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Wax ON! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffered();
            }
        } catch (InterruptedException e) {
            System.out.println("WaxOn InterruptedException");
        }
        System.out.println("Ending Wax On task");
    }
}
