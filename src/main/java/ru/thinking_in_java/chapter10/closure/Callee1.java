package ru.thinking_in_java.chapter10.closure;

public class Callee1 implements Incrementable {

    private int i = 0;

    public void increment() {
        i++;
        System.out.println(i);
    }
}
