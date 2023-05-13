package ru.java_philosophy.chapter21.page904;

public class DaemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true){
            Thread.yield();
        }
    }
}
