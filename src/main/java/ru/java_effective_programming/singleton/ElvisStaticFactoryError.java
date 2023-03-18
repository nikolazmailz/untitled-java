package ru.java_effective_programming.singleton;

public class ElvisStaticFactoryError {

    private static int element = 0;

    private static final ElvisStaticFactoryError INSTANCE = new ElvisStaticFactoryError();

    private ElvisStaticFactoryError() {
        if (element > 0) {
            throw new RuntimeException("ElvisStaticFactoryError manual check");
        }
        element++;
        System.out.println("constructor ElvisStaticFactory");
    }

    public static ElvisStaticFactoryError getInstance() {
        return INSTANCE;
    }

    public void check() {
        System.out.println("ElvisStaticFactoryError check " + element);
    }

}
