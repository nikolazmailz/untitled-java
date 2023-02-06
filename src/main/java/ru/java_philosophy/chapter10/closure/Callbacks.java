package ru.java_philosophy.chapter10.closure;

public class Callbacks {

    public static void main(String[] args) {
        Callee1 cl = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(cl);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
