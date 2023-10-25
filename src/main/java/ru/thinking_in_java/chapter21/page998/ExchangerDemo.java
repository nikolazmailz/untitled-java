package ru.thinking_in_java.chapter21.page998;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerDemo {
    static int size = 10;
    static int delay = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();

        List<Fat> producerList = new CopyOnWriteArrayList<Fat>(),
                consumerList = new CopyOnWriteArrayList<Fat>();

        exec.execute(new ExchangerProducer<Fat>(xc, BasicGenerator.create(Fat.class), producerList));
        exec.execute(new ExchangerConsumer<Fat>(xc, consumerList));
        //exec.execute(new ExchangerConsumer<Fat>(xc, consumerList));

        TimeUnit.MILLISECONDS.sleep(delay);
        exec.shutdownNow();
    }
}
