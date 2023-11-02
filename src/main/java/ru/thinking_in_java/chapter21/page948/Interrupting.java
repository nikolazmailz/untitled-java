package ru.thinking_in_java.chapter21.page948;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws InterruptedException {
//        test(new SleepBlocked());
//        test(new IOBlocked(System.in));
//        test(new SynchronizedBlocked());
//        TimeUnit.SECONDS.sleep(3);
//        System.out.println("Aborting with System.exit(0)");
//        System.exit(0);


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {


                synchronized (this) {
                    for (int i = 0; i < 1_000; i++) {

                        System.out.println(i);
                        try {
                            check(Thread.currentThread().isInterrupted());
//                        if(Thread.currentThread().isInterrupted()){
//                            break;
//                        }
                        } catch (InterruptedException e) {
                            throw new RuntimeException("RuntimeException");
                        }
                    }
                }
            }


            private void check(boolean b) throws InterruptedException {
                if (b) throw new InterruptedException(" sad asd");
            }
        });

        t.start();
        TimeUnit.MILLISECONDS.sleep(1);
        System.out.println("off");
        t.interrupt();


    }

}
