package ru.thinking_in_java.chapter21.page985;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {


    @Override
    public String call() throws Exception {
        return "MyCallable";
    }
}
