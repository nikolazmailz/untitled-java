package ru.java_philosophy.chapter21.page925;

import ru.java_philosophy.chapter21.IntGenerator;
import ru.java_philosophy.chapter21.page920.EvenChecker;

public class SynchronizedEvenGenerator extends IntGenerator {

    private volatile int currentValue = 0;

    @Override
    public synchronized int next() {
        ++currentValue;
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args){
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
