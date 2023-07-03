package ru.thinking_in_java.chapter21.page935;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitPairManager1 extends PairManager {

    private Lock lock = new ReentrantLock();

    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}
