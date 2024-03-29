package ru.thinking_in_java.chapter21.page935;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {

    static void testApproaches(PairManager pman1, PairManager pman2){
        ExecutorService exec = Executors.newCachedThreadPool();

        PairManipulator
            pm1 = new PairManipulator(pman1),
            pm2 = new PairManipulator(pman2);

        PairChecker
            pChecker1 = new PairChecker(pman1),
            pChecker2 = new PairChecker(pman2);

        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pChecker1);
        exec.execute(pChecker2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager
            pman1 = new PairManager1(),
            pman2 = new PairManager2();
        testApproaches(pman1, pman2);
    }

}
