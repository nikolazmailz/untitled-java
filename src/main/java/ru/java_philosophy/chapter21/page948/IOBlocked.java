package ru.java_philosophy.chapter21.page948;

import java.io.IOException;
import java.io.InputStream;

public class IOBlocked implements Runnable {

    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("Wait");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else {
                System.out.println("RuntimeException");
               throw new RuntimeException(e);
            }
        }
    }
}
