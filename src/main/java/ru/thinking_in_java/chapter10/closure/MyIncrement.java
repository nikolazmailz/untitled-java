package ru.thinking_in_java.chapter10.closure;

public class MyIncrement {

    public void increment() {
        System.out.println("Другая операция");
    }

    public static void f(MyIncrement mi) {
        mi.increment();
    }
}
