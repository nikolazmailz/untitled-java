package ru.java_philosophy.chapter3;

public class Main {


    public static void main(String[] args) {

        Main main = new Main();

        String s1 = new String("A");
        String s2 = "A";
        String s3 = new String("A");
        String s4 = "A";
        String s5 = s2;
        String s6 = s1;

        System.out.println("s1 s2");
        main.action(s1, s2);
        System.out.println("\n");
        System.out.println("s1 s3");
        main.action(s1, s3);
        System.out.println("\n");
        System.out.println("s2 s3");
        main.action(s1, s3);

        System.out.println("\n");
        System.out.println("s2 s4");
        main.action(s1, s4);

        System.out.println("\n");
        System.out.println("s2 s5");
        main.action(s1, s5);

        System.out.println("\n");
        System.out.println("s6 s1");
        main.action(s6, s1);
    }


    public void action(String s1, String s2){
        System.out.println(s1 + " " + s2 + "\n");
        System.out.println(s1.equals(s2) + "\n");
        System.out.println(s1 != s2 + "\n");
        System.out.println(s1 == s2 + "\n");
    }

}
