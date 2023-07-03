package ru.thinking_in_java.chapter21.page904;

public class DaemonsDontRunFinally {

    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}
