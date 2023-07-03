package ru.thinking_in_java.chapter21.page948;

public class SynchronizedBlocked implements Runnable{

    public synchronized void f(){
        while (true){
            Thread.yield();
        }
    }

    public SynchronizedBlocked(){
        new Thread(() -> f()).start();
    }

    @Override
    public void run() {
        System.out.println("SynchronizedBlocked Trying to call f()");
        f();
        System.out.println("SynchronizedBlocked Exiting SynchronizedBlocked.run()");
    }
}
