package ru.thinking_in_java.chapter21.page952;

public class Blocked2 implements Runnable{

    BlockedMutex blockedMutex = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("Wait for f() in BlockedMutex");
        blockedMutex.f();
        System.out.println("Broken out of blocked call");
    }
}
