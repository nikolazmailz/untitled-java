package ru.java_philosophy.chapter21.page920;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import ru.java_philosophy.chapter21.IntGenerator;

public class EvenChecker implements Runnable {

    private IntGenerator generator;

    private Lock lock = new ReentrantLock();

    public EvenChecker(IntGenerator g) {
        this.generator = g;
    }

    @Override
    public void run() {
        int x;
        while (!generator.isCanceled()) {
            lock.lock();
            try {
                x = generator.next();

                if (x % 2 != 0 || x > 1000) {
                    System.out.println("Thread " + Thread.currentThread().getName());
                    System.out.println("Wow generator.next() exception rice conditions");
                    generator.cancel();
                }
                System.out.println(x + " Thread " + Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        }
    }

    public static void test(IntGenerator g, int count) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(g));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator g) {
        test(g, 3);
    }
}
