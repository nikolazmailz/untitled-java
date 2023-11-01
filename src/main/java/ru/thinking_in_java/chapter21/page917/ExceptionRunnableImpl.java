package ru.thinking_in_java.chapter21.page917;

public class ExceptionRunnableImpl implements Runnable{

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("ExceptionThread2 run() by " + t.getName());
        System.out.println("ExceptionThread2 eh = " + t.getUncaughtExceptionHandler());
        throw new NullPointerException();
    }
}
