package ru.java_philosophy.chapter21.page940;

public class SyncObject {

    public static void main(String[] args) {
        final DualSynch dualSynch = new DualSynch();
        new Thread(() -> dualSynch.f()).start();
        dualSynch.g();
    }

}
