package ru.thinking_in_java.chapter21.page998;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerProducer<T> implements Runnable {

    private Exchanger<List<T>> exchanger;
    private Generator<T> generator;
    private List<T> holder;

    ExchangerProducer(Exchanger<List<T>> exchanger,
                      Generator<T> generator,
                      List<T> holder) {
        this.exchanger = exchanger;
        this.generator = generator;
        this.holder = holder;
    }

    public void run(){
        try {
            while (!Thread.interrupted()){
                for (int i = 0; i < ExchangerDemo.size; i++) {
                    holder.add(generator.next());
                }
                System.out.println("ExchangerProducer " + holder.size());
                holder = exchanger.exchange(holder);
                System.out.println("ExchangerProducer after exchange " + holder.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
