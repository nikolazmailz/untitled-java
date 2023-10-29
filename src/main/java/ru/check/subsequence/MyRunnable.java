package ru.check.subsequence;

public class MyRunnable implements Runnable{

    private String name;

    MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("MyRunnable " + name);
    }
}
