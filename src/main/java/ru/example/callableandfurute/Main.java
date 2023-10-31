package ru.example.callableandfurute;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> future = CallableImpl.create();
        System.out.println("main " + future.get());

        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> futureExec = exec.submit(new CallableImpl());
        exec.shutdown();
        System.out.println("futureExec " + futureExec.get());

    }
}
