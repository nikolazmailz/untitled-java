//package ru.java_philosophy.chapter21.page917;
//
//import ru.thinking_in_java.chapter21.page917.ExceptionThread2;
//import ru.thinking_in_java.chapter21.page917.HandlerExceptionFactory;
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
//        ExecutorService exec = Executors.newCachedThreadPool(new HandlerExceptionFactory());
//        try {
//
//            exec.execute(new ExceptionThread2());
//        }catch (RuntimeException e){
//            System.out.println("dasd " + e.getMessage());
//        } finally {
//            exec.shutdown();
//        }
//    }
//}
