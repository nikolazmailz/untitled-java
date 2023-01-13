package ru.java_philosophy.chapter2.exercises07;

public class Main {

    public static void main(String[] args){
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();

        System.out.println(st1.i);
        System.out.println(st2.i);

        StaticTest.i++;

        System.out.println(st1.i);
        System.out.println(st2.i);

        Incrementable incrementable = new Incrementable();
        incrementable.increment();

        System.out.println(st1.i);
        System.out.println(st2.i);

        Incrementable.increment();

        System.out.println(st1.i);
        System.out.println(st2.i);
    }
}
