package ru.check.threadlocal;

public class ThreadDemo implements Runnable {

    int counter;
    ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<>();

    public void run() {
        counter++;

        if(threadLocalCounter.get() != null) {
            threadLocalCounter.set(threadLocalCounter.get() + 1);
        } else {
            threadLocalCounter.set(0);
        }
        printCounters();
    }

    public void printCounters(){
        System.out.println("Counter: " + counter);
        System.out.println("threadLocalCounter: " + threadLocalCounter.get());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();

        Thread t1 = new Thread(threadDemo);
        Thread t2 = new Thread(threadDemo);
        Thread t3 = new Thread(threadDemo);

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();

    }
}
