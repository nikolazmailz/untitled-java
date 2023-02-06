package ru.java_philosophy.chapter10.clousre;

public class MyIncrement {

    public void increment() {
        System.out.println("Другая операция");
    }

    public static void f(MyIncrement mi) {
        mi.increment();
    }
}
