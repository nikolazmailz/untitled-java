package ru.thinking_in_java.chapter21.page914;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Sleeper s1 = new Sleeper("S1", 1500),
                s2 = new Sleeper("S2", 3500);

        Join j1 = new Join("J1", s1),
             j2 = new Join("J2", s2);

        s1.interrupt();
        Thread.sleep(1000);
        s2.interrupt();
    }

}
