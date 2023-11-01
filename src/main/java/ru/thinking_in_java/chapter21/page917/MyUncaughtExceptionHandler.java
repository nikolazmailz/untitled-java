package ru.thinking_in_java.chapter21.page917;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("MyUncaughtExceptionHandler t " + t.getName());
        System.out.println("MyUncaughtExceptionHandler caught " + e);
    }
}
