package ru.algorithms;

public class Knapsack {

    public static void main(String[] args) {
// Пример данных
        int[] weights = {2, 3, 4, 5};  // Веса предметов
        int[] values = {3, 4, 5, 6};  // Ценности предметов
        int maxWeight = 5;            // Максимальный вес рюкзака

        // Решение задачи
        int maxValue = new Knapsack().knapsack(weights, values, maxWeight);
        System.out.println("Максимальная ценность: " + maxValue);
    }

    public int knapsack(int[] weights, int[] values, int maxWeight) {
        int n = weights.length; // Количество предметов
        int[][] dp = new int[n + 1][maxWeight + 1];

        // Заполнение таблицы dp
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= maxWeight; w++) {
                if (weights[i - 1] <= w) {
                    // Выбираем максимальное значение между включением и исключением предмета
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    // Текущий предмет не помещается в рюкзак
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][maxWeight];
    }
}
