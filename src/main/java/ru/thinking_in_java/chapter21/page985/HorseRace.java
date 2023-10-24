package ru.thinking_in_java.chapter21.page985;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HorseRace {
    static final int FINISH_LINE = 75;

    private List<Horse> horseList = new ArrayList<>();

    private ExecutorService exec = Executors.newCachedThreadPool();

    private CyclicBarrier barrier;

    HorseRace(int nHorses, final int pause){
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    s.append("=");
                }
                System.out.println(s);
                for (Horse horse: horseList){
                    System.out.println(horse.tracks());
                }
                for(Horse horse: horseList){
                    if(horse.getStrides() >= FINISH_LINE){
                        System.out.println(horse + " won!");
                        exec.shutdownNow();
                        return;
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horseList.add(horse);
            exec.execute(horse);
        }
    }

    private void pr(){
        System.out.println("pr System");
    }

    public static void main(String[] args)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int nHorses = 7;
        int pause = 200;
        HorseRace h = new HorseRace(nHorses, pause);

//        Class hClass = h.getClass();
//        Method[] methods = hClass.getDeclaredMethods();
//
//        Method pr = hClass.getDeclaredMethod("pr");
        //pr.invoke(hClass);
//        pr.setAccessible(true);
//        pr.invoke(h);
//        System.out.println(pr);
//
//        for (Method method : methods) {
//            System.out.println("method.getName() " +  method.getName());
//        }

//        Lock lock = new ReentrantLock();
//        Condition condition = lock.newCondition();
//
//
//        Thread.currentThread().isAlive();
//
//
//        FutureTask futureTask = new FutureTask(new MyCallable());
//        new Thread(futureTask).start();
//        try {
//            System.out.println(futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        ExecutorService exec = Executors.newCachedThreadPool();
//
//        exec.submit(new MyCallable());

    }
}
