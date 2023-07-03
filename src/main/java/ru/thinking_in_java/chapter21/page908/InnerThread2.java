package ru.thinking_in_java.chapter21.page908;

public class InnerThread2 {

    private int countDown = 5;
    private Thread t;

    public InnerThread2() {
        t = new Thread() {
            public void run() {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        System.out.println("END " + this);
                        return;
                    }
                }
            }

            public String toString() {
                return "#" + getName() + "(" + countDown + ")";
            }
        };
        t.start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new InnerThread2();
        }
    }

}
