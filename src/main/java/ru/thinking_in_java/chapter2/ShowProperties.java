package ru.thinking_in_java.chapter2;

public class ShowProperties {

    public static void main(String... args){
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
    }

}
