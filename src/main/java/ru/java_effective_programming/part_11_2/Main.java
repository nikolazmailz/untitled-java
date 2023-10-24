package ru.java_effective_programming.part_11_2;

import java.util.HashSet;

public class Main {

    public static void main(String... args){
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver((s,e) -> System.out.println(e));
        set.addNumPlusNum((s,e) -> System.out.println(((s * e) / (s + e))));

        for (int i=0; i< 100; i++){
            set.add(i);
        }

        for (int i=0; i < 100; i++){
            set.add(Double.valueOf(i), i+1d);
        }

    }
}
