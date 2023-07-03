package ru.thinking_in_java.chapter21.page925;

import ru.thinking_in_java.chapter21.IntGenerator;
import ru.thinking_in_java.chapter21.page920.EvenChecker;

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
