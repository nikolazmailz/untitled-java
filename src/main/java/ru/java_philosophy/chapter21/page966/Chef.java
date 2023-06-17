package ru.java_philosophy.chapter21.page966;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable{

    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal != null){
                        System.out.println("Chef wait()");
                        wait();
                        System.out.println("Chef wait() off");
                    }
                }
                if(++count == 10){
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up! ");
                synchronized (restaurant.waitPerson){
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef InterruptedException");
        }
    }
}
