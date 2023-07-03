package ru.thinking_in_java.chapter2.exercises08;

import java.util.Random;

public class Main {

    public static void main(String[] args){
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();
        StaticTest st3 = new StaticTest();
        StaticTest st4 = new StaticTest();

        System.out.println(StaticTest.i);
        System.out.println(st1.i == st2.i && st3.i == st4.i);

        Random random = new Random();
        int x = random.nextInt(3) + 1;
        System.out.println(x);

        switch (x){
           case  1:
               st1.i+=1;
               break;
           case  2:
               st2.i+=2;
               break;
           case  3:
               st3.i+=3;
               break;
           case  4:
               st4.i+=4;
               break;
        }
        System.out.println(StaticTest.i);
        System.out.println(st1.i == st2.i && st3.i == st4.i);
    }

}
