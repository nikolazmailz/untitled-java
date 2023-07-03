package ru.thinking_in_java.chapter21.page935;

public class PairManager1 extends PairManager{

    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
