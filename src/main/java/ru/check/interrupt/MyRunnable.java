package ru.check.interrupt;

public class MyRunnable implements Runnable{

    private String name;

    MyRunnable(String n){
        this.name = n;
    }

    @Override
    public void run() {
        System.out.println("Enter " + name);
        long time = System.currentTimeMillis();
        while(!Thread.currentThread().isInterrupted()){
            for (long i = 0; i < 1_0000; i++) {
                double d = 1_000_000;
                while (d > 0){
                    d--;
                    //System.out.println(d);
                }
                //System.out.println(i);
                //System.out.println(d);
                if(i+1 == 1_0000){
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("Time name " + name + " " + (System.currentTimeMillis() - time));
        System.out.println("Exit " + name);
    }
}
