package ru.algorithms;

public class PrefixSum {
    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 2, 4, 0}; // Исходный массив
        int[] prefixSum = new int[nums.length];

        // Вычисление префиксной суммы
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // Пример использования
        int left = 2; // Начальный индекс подотрезка
        int right = 4; // Конечный индекс подотрезка
        int sum = (left == 0) ? prefixSum[right] : prefixSum[right] - prefixSum[left - 1];

        System.out.println("Сумма элементов с индекса " + left + " до " + right + ": " + sum);
    }
}