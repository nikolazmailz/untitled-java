package ru.java_philosophy.chapter21;

abstract public class IntGenerator {
    private volatile boolean canceled = false;

    abstract public int next();
    public void cancel(){ canceled = true;}
    public boolean isCanceled(){ return canceled;}
}
