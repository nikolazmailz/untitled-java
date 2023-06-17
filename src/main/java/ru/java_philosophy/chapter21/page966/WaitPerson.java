package ru.java_philosophy.chapter21.page966;

public class WaitPerson implements Runnable{

    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal == null){
                        System.out.println("WaitPerson wait()");
                        wait();
                        System.out.println("WaitPerson wait() off");
                    }
                }
                System.out.println("WaitPerson got " + restaurant.meal);
                synchronized (restaurant.chef){
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson InterruptedException");
        }
    }
}
