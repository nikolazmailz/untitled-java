package ru.java_effective_programming.singleton;

public class ElvisStaticFactory {
    private static int element = 0;

    private static final ElvisStaticFactory INSTANCE = new ElvisStaticFactory();

    private ElvisStaticFactory(){
        element++;
        System.out.println("constructor ElvisStaticFactory");
    }

    public static ElvisStaticFactory getInstance(){
        return INSTANCE;
    }

    public void check(){
        System.out.println("ElvisStaticFactory check "+ element);
    }

}
