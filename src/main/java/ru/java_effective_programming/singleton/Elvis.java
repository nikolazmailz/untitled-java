package ru.java_effective_programming.singleton;

public class Elvis {

    public static final Elvis INSTANCE = new Elvis();

    private Elvis(){
        System.out.println("private Elvis");
    }

    public void check(){
        System.out.println("Elvis check");
    }
}
