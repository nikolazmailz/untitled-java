package ru.thinking_in_java.chapter21.page948;

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
            System.out.println("IOBlocked wait");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("IOBlocked Interrupted from blocked I/O");
            } else {
                System.out.println("IOBlocked RuntimeException");
               throw new RuntimeException(e);
            }
        }
    }
}
