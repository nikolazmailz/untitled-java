package ru.thinking_in_java.chapter21.page931;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber(){
        return serialNumber++;
    }
}
