package ru.thinking_in_java.chapter2.exercises10;

public class Main {

    public static void main(String[] args) {
        String[] args2 = new String[]{"param", "param2", "param3"};
        for (String str : args2) {
            System.out.println("arg = " + str);
        }
    }
}
