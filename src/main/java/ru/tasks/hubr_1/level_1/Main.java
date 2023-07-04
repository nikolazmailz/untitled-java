package ru.tasks.hubr_1.level_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    private static Random r = new Random(47);

    public static void main(String[] args) {

        /**
         * 1.0. Максимальное, минимальное и среднее значение
         *
         * Задача:
         *
         * Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
         *
         * Для генерации случайного числа используйте метод Math.random(), который возвращает значение в промежутке [0, 1].
         * */
        solution();


    }

    private static void solution() {
        int nextInt1 = nextInt();
        System.out.println("Random r.nextInt() " + nextInt1);
        ArrayList<Integer> is = new ArrayList<>(nextInt1);
        for (int i = 0 ; i < nextInt1; i++) {
            is.add(nextInt100());
        }
        System.out.println(is);
        List<Integer> collect = is.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect.get(0));
        int half = is.size() / 2;
        System.out.println(collect.get(half));
        System.out.println(collect.get(collect.size() - 1));
    }

    private static int nextInt() {
        return r.nextInt(10);
    }

    private static int nextInt100() {
        return r.nextInt(100);
    }
}
