package ru.java_philosophy.chapter21.page969;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable{

    private Car car;

    public WaxOff(Car car){
        this.car = car;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                car.waitForWaxing();
                System.out.println("Wax OFF! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("WaxOff InterruptedException");
        }
        System.out.println("Ending Wax Off task");
    }
}
