package ru.java_philosophy.chapter4;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /**
         * Напишите программу, которая выводит числа от 1 до 100.
         * */
        for(int i = 1; i<=100; i++){
            System.out.println(i);
        }
        System.out.println("\n");

        /**
         * Напишите программу, которая генерирует 25 случайных значений типа int.
         * Для каждого значения команда if-else сообщает,
         * в каком отношении оно находится с другим случайно сгенерированным числом (больше, меньше, равно).
         * */
        Random random = new Random(41);
        int im[] = new int[5];
        for(int i = 0; i<5; i++){
            im[i] = random.nextInt(5);
            System.out.println(im[i]);
        }

        for (int i = 0; i < 5; i++) {
            int iValue = im[i];
            for (int j = 0; j < 5; j++) {
                System.out.println("iValue: " + iValue + " im[j]: " + im[j]);
                System.out.println("< " + (iValue < im[j]));
                System.out.println("> " + (iValue > im[j]));
                System.out.println("== " + (iValue == im[j]));
            }
        }
        System.out.println("\n");

        /**
         * Напишите программу, использующую два вложенных цикла for и оператор остатка (%)
         * для поиска и вывода простых чисел
         * (то есть целых чисел, не делящихся нацело ни на какое другое число,
         * ±кроме себя и 1).
         * */
        int min = 1;
        int max = 10;

        int im2[] = new int[5];
        for(int i = 0; i<5; i++){
            im2[i] = (int)Math.floor(Math.random() * (max - min + 1) + min);
            System.out.println(im2[i]);
        }

        for (int i = 0; i < im2.length; i++) {
            int iValue = im2[i];
            for (int j = 0; j < im2.length; j++) {
                if ((im2[j] % iValue) == 0) {
                    System.out.println("im2[j] % iValue " + im2[j] + " " + iValue);
                }
            }
        }
    }

}
