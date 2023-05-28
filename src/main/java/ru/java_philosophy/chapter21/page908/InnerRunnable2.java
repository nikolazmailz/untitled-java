package ru.java_philosophy.chapter21.page908;

public class InnerRunnable2 {

    private int countDown = 5;
    private Thread inner;

    public InnerRunnable2() {
        inner = new Thread(new Runnable() {
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
        });
        inner.start();
    }

    public static void main(String[] args) {
        for(int i = 0; i< 5; i ++){
            new InnerRunnable2();
        }
    }

}
