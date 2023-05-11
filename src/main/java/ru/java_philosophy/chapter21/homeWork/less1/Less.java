package ru.java_philosophy.chapter21.homeWork.less1;

public class Less implements Runnable {

    private static int taskCount = 0;
    private final int id = taskCount++;

    public Less(){
        System.out.println("start #" + id);
        Thread t = new Thread(this);
        t.start();
        System.out.println("end #" + id);
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            System.out.println("message #" + id + " " + i);
            Thread.yield();
        }
    }

    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            System.out.println("new Less() " + i);
            new Less();
            Thread.yield();
        }
    }
}
