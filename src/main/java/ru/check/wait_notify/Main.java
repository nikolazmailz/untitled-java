package ru.check.wait_notify;

import java.io.InputStream;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    static List<String> strings = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        new Operator().start();
        new Machine().start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("System.exit(0)");
        System.exit(0);
    }

    static class Operator extends Thread {

        @Override
        public void run() {
            while (true){
                Scanner scanner = new Scanner(System.in);
                synchronized (strings){
                    strings.add(scanner.nextLine());
                    strings.notify();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Machine extends Thread {

        @Override
        public void run() {
            while (strings.isEmpty()){
                synchronized (strings){
                    try {
                        strings.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(strings.remove(0));
                }
            }
        }
    }

}
