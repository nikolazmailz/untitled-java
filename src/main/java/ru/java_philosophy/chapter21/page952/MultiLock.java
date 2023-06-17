package ru.java_philosophy.chapter21.page952;

public class MultiLock {

    public synchronized void f(int count){
        if(count-- > 0){
            System.out.println("f() calling f2() with count " + count);
            f2(count);
        }
        System.out.println("return f()");
    }

    public synchronized void f2(int count){
        if(count-- > 0){
            System.out.println("f2() caliing f() with count " + count);
            f(count);
        }
        System.out.println("return f2()");
    }

    public static void main(String[] args) {
        final MultiLock multiLock = new MultiLock();
        new Thread(){
            @Override
            public void run() {
                multiLock.f(10);
            }
        }.start();
    }
}
