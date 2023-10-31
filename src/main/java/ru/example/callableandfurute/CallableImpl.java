package ru.example.callableandfurute;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableImpl implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "CallableImpl";
    }

    public static Future<String> create(){
        CallableImpl callable = new CallableImpl();
        FutureTask<String> future = new FutureTask<>(callable);
        new Thread(future).start();
        return future;
    }
}
