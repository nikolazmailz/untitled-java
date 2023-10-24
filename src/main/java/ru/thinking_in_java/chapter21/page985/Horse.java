package ru.thinking_in_java.chapter21.page985;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable {

    private static int counter = 0;
    private final int id = counter++;

    private int strides = 0;

    private int stridesNow = 0;

    private static Random random = new Random(47);
    private static CyclicBarrier barrier;

    Horse(CyclicBarrier b) {
        barrier = b;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    stridesNow = random.nextInt(5);
                    //System.out.println("nextInt " + nextInt);
                    strides += stridesNow;
                }
                System.out.println("barrier.await() " + this);
                barrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return "Horse " + id + " ";
    }

    public String tracks(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            sb.append("*");
        }
        sb.append(id + " - " + stridesNow + "/" + getStrides());
        return sb.toString();
    }
}
