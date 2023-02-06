package ru.java_philosophy.chapter4;


import java.util.Random;

public class IfElse2 {

    static int test(int testVal, int target, int begin, int end) {
        System.out.println(
            testVal + " testVal. " +
                target + " target. " +
                begin + " begin. " +
                end + " end"
        );
        try {
            for (int i : range(begin, end)) {
                if (testVal == i) {
                    System.out.println("testVal in range(begin, end): " + testVal);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (testVal > target) {
            return +1;
        } else if (testVal < target) {
            return -1;
        } else {
            return 0;
        }
    }

    private static int[] range(int begin, int end) throws IllegalArgumentException {
        if (begin < end) {
            int ii[] = new int[end - begin];
            for (int i = 0; i < (end - begin); i++) {
                ii[i] = begin + i;
            }
            return ii;


        } else {
            throw new IllegalArgumentException("begin < end");
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        //System.out.println(random.nextInt(10));
        System.out.println(
            IfElse2.test(random.nextInt(10), random.nextInt(12), random.nextInt(8), random.nextInt(17))
        );
    }

}
