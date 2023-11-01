package ru.check.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Runnable r = () -> System.out.println("super x");

        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 3; i++) {
            exec.execute(r);
        }

    }
}
