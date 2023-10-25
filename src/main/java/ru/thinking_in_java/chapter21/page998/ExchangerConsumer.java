package ru.thinking_in_java.chapter21.page998;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerConsumer<T> implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;


    ExchangerConsumer(
            Exchanger<List<T>> exchanger,
            List<T> holder
    ) {
        this.exchanger = exchanger;
        this.holder = holder;
    }

    public void run(){
        try{
            while(!Thread.interrupted()){
                System.out.println("ExchangerConsumer " + holder.size() + " id " + id);
                holder = exchanger.exchange(holder);
                System.out.println("ExchangerConsumer after exchange " + holder.size() + " id " + id);
                for(T x: holder){
                    value = x;
                    holder.remove(x);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final value: " + value);
    }
}
