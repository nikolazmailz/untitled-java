package ru.java_philosophy.chapter21.page959;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {

    private Car car;

    public WaxOff(Car c){
        car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                car.waitingForWaxed();
                System.out.println("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffered();
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException WaxOff");
        }
        System.out.println("Ending Wax Off task");
    }
}
