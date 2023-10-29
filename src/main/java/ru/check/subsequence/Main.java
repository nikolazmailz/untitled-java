package ru.check.subsequence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();

        exec.execute(new MyRunnable("1"));
        exec.execute(new MyRunnable("2"));
        exec.execute(new MyRunnable("3"));

        exec.shutdown();

    }
}
