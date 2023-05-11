package ru.java_philosophy.chapter21;

public class BasicThreads {

    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for ListOff");
    }
}
