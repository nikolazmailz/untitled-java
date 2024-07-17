package ru.leetcode.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args){


//        System.out.println("Hello world");

        int[] arr = {9,4,9,6,7,4,5};
        int n = getFirstUnique(arr);
        System.out.println(n);

    }

    private static int getFirstUnique(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        int x = 0;
        for (int i= 0 ; i < arr.length; i++) {
            list.add(arr[i]);
        }
        for(int i= 0 ; i < arr.length; i++){
            if (list.stream().filter(Predicate.isEqual(arr[i])).count() == 1) {
                x = arr[i];
                break;
            }
        }
        return x;
    }


}
