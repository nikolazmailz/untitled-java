package ru.java_philosophy.chapter21.page959;

public class Car {
    private boolean waxOn = false;

    public synchronized void waxed(){
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffered(){
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitingForWaxed() throws InterruptedException {
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitingForBuffering() throws InterruptedException {
        while (waxOn == true){
            wait();
        }
    }

}
