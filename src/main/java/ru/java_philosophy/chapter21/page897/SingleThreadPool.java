package ru.java_philosophy.chapter21.page897;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ru.java_philosophy.chapter21.LiftOff;

public class SingleThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

}
