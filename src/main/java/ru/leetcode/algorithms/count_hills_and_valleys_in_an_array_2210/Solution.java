package ru.leetcode.algorithms.count_hills_and_valleys_in_an_array_2210;


/**
 * 2210. Count Hills and Valleys in an Array
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given a 0-indexed integer array nums. An index i is part of a hill in nums if the closest non-equal neighbors of i are smaller than nums[i]. Similarly, an index i is part of a valley in nums if the closest non-equal neighbors of i are larger than nums[i]. Adjacent indices i and j are part of the same hill or valley if nums[i] == nums[j].
 * <p>
 * Note that for an index to be part of a hill or valley, it must have a non-equal neighbor on both the left and right of the index.
 * <p>
 * Return the number of hills and valleys in nums.
 * <p>
 * <p>
 * Условие задачи 2210 заключается в следующем:
 * <p>
 * Вам дан массив целых чисел nums, проиндексированный с нуля.
 * Индекс i массива nums считается частью холма (hill), если ближайшие неравные соседи i (по левую и правую стороны) меньше, чем nums[i].
 * Аналогично, индекс i считается частью долины (valley), если ближайшие неравные соседи i больше, чем nums[i].
 * Если два соседних индекса, например, i и j имеют одинаковое значение (nums[i] == nums[j]), то они считаются частью одного и того же холма или долины.
 * Для того чтобы индекс мог быть частью холма или долины, у него должны быть соседи, отличающиеся от его значения с обеих сторон.
 * Требуется найти общее количество холмов и долин в массиве nums.
 */
public class Solution {

    public static void main(String[] args) {
        int answer = new Solution().countHillValley2(
//                new int[]{6,6,5,5,4,1}
//                new int[]{2,4}
//                new int[]{2,4,1,1,6,5}
//                new int[]{1, 2, 1}
//                new int[]{1, 2, 2, 2, 1}
                new int[]{1, 1, 1, 2, 3, 4, 4, 4, 3, 3, 3, 5, 6, 6, 6, 6, 5, 4, 3, 3, 3, 2, 2, 2, 3, 3, 3}
        );
        System.out.println(answer);
    }


    public int countHillValley(int[] nums) {
        int hill = 0;
        int valley = 0;
        int left;
        int right;

        if (nums.length < 3) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {

            if (i == 0 || i + 1 == nums.length) {
                continue;
            }

            left = nums[i - 1];

            while ((i < nums.length - 2) && (nums[i] == nums[i + 1])) {
                i++;
            }

            right = nums[i + 1];

            if (left < nums[i] && nums[i] > right) {
                hill++;
            }

            if (left > nums[i] && nums[i] < right) {
                valley++;
            }
        }

        return hill + valley;
    }

    public int countHillValley2(int[] nums) {
        int hill = 0, valley = 0;

        if (nums.length < 3) {
            return 0;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            // Пропускаем одинаковые элементы
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            int left = nums[i - 1];
            int right = nums[i + 1];

            // Пропускаем соседние дубликаты справа
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
                right = nums[i + 1];
            }

            if (left < nums[i] && nums[i] > right) {
                hill++;
            } else if (left > nums[i] && nums[i] < right) {
                valley++;
            }
        }

        return hill + valley;
    }

}

