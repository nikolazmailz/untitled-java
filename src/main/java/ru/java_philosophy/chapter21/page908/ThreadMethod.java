package ru.java_philosophy.chapter21.page908;

public class ThreadMethod {

    private int countDown = 5;
    private Thread t;

    public void runMethod() {
        if (t == null) {
            t = new Thread(
                new Runnable() {

                    public String toString() {
                        return Thread.currentThread().getName() + "#" + countDown;
                    }

                    @Override
                    public void run() {
                        while (true) {
                            System.out.println(this);
                            if (--countDown == 0) {
                                System.out.println("END #" + this);
                                return;
                            }
                        }
                    }
                }
            );
            t.start();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new ThreadMethod().runMethod();
        }
    }

}
