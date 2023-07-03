package ru.thinking_in_java.chapter21.page925;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import ru.thinking_in_java.chapter21.IntGenerator;
import ru.thinking_in_java.chapter21.page920.EvenChecker;

public class MutexEvenGenerator extends IntGenerator {

    private volatile static int currentValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentValue;
            ++currentValue;
            return currentValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
