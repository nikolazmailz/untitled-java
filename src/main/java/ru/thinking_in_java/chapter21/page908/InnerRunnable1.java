package ru.thinking_in_java.chapter21.page908;

public class InnerRunnable1 {

    private int countDown = 5;

    private class Inner implements Runnable {

        Thread t = new Thread(this);

        Inner() {
            t.start();
        }

        public String toString() {
            return Thread.currentThread().getName() + "#" + countDown;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(this);
                if (--countDown == 0) {
                    System.out.println("END " + this);
                    return;
                }
            }
        }
    }

    public InnerRunnable1(){
        new Inner();
    }

    public static void main(String[] args) {
        for (int i=0; i<5; i++){
            new InnerRunnable1();
        }
    }

}
