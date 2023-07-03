package ru.thinking_in_java.chapter21.page914;

import java.time.LocalDateTime;

public class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name, int duration){
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        }catch (InterruptedException ie){
            System.out.println("Sleeper InterruptedException " + ie.getMessage());
        }
        System.out.println(getName() + " has awakened " + LocalDateTime.now());
    }
}
