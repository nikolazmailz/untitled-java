package ru.thinking_in_java.chapter21.page917;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaptureUncaughtException {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(
            new HandlerExceptionFactory()
        );

        exec.execute(new ExceptionRunnableImpl());
        exec.shutdown();
    }

}
