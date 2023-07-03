package ru.thinking_in_java.chapter21.page955;

import java.util.concurrent.TimeUnit;

public class Blocked3 implements Runnable {

    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                NeedsCleanup nc1 = new NeedsCleanup(1);
                try {

                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);

                    NeedsCleanup nc2 = new NeedsCleanup(2);
                    try {
                        System.out.println("Calculating");
                        for (int i = 0; i < 250_000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("d " + d);
                        System.out.println("Finished time-consuming operation");
                    } finally {
                        nc2.cleanup();
                    }

                } finally {
                    nc1.cleanup();
                }
            }
            System.out.println("Exiting via while() test");
        } catch (Exception e) {
            System.out.println("Exiting via InterruptedException");
        }
    }
}
