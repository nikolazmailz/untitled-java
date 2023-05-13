package ru.java_philosophy.chapter21.page900;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import ru.java_philosophy.chapter21.LiftOff;

public class SleepingTask extends LiftOff {

    @Override
    public void run(){
        while (countDown-- > 0){
            System.out.println(status());
            //old style
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //style after SE5/6
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i<5; i++){
            exec.execute(new SleepingTask());
        }
        System.out.println("exec.shutdown()");
        exec.shutdown();
    }
}
