//package ru.java_philosophy.chapter21.page917;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ExceptionThread implements Runnable {
//
//    @Override
//    public void run() {
//        throw new RuntimeException();
//    }
//
//    public static void main(String[] args) {
//        /**
//        *   Thread t = new Thread(new ExceptionThread());
//        *   t.start();
//        */
//        try {
//            ExecutorService exec = Executors.newCachedThreadPool();
//            exec.execute(new ExceptionThread());
//        }catch (RuntimeException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}
