package ru.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Создаем хэш-таблицу для хранения числа и его индекса
        Map<Integer, Integer> map = new HashMap<>();

        // Проходим по массиву
        for (int i = 0; i < nums.length; i++) {
            // Вычисляем число, которое нужно найти
            int complement = target - nums[i];

            // Если оно уже есть в хэш-таблице, возвращаем индексы
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Иначе добавляем текущее число и его индекс в хэш-таблицу
            map.put(nums[i], i);
        }

        // Если решение не найдено (хотя гарантируется, что оно есть)
        throw new IllegalArgumentException("No solution found");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        // Выводим результат
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
