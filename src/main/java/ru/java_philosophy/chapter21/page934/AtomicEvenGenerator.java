package ru.java_philosophy.chapter21.page934;

import java.util.concurrent.atomic.AtomicInteger;
import ru.java_philosophy.chapter21.IntGenerator;
import ru.java_philosophy.chapter21.page920.EvenChecker;

public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEventValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentEventValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
