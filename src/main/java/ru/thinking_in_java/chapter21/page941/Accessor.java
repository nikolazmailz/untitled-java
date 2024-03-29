package ru.thinking_in_java.chapter21.page941;

public class Accessor implements Runnable{
    private final int id;
    public Accessor(int id){
        this.id = id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    public String toString(){
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}
