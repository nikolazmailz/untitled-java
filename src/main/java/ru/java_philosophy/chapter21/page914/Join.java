package ru.java_philosophy.chapter21.page914;

import java.time.LocalDateTime;

public class Join extends Thread {

    private Sleeper sleeper;

    public Join(String name, Sleeper s){
        super(name);
        this.sleeper = s;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Join InterruptedException " + e.getMessage());
        }
        System.out.println(getName() + " has awakened " + LocalDateTime.now());
    }
}
