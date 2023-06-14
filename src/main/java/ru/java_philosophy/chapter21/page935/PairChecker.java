package ru.java_philosophy.chapter21.page935;

public class PairChecker implements Runnable{
    private PairManager pm;
    public PairChecker(PairManager pm){
        this.pm = pm;
    }

    public void run(){
        while (true){
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }

}
