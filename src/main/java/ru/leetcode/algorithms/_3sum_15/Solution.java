package ru.leetcode.algorithms._3sum_15;


import java.util.*;
import java.util.stream.Stream;

/**
 * Given an integer array nums, return all the triplets
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * В этом задании требуется написать программу,
 * которая принимает массив целых чисел nums
 * и находит все уникальные комбинации из трёх чисел (триплетов) из массива, которые в сумме дают 0.
 * <p>
 * Input: nums = [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 */
public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> my = new Solution().getTripletsByZero(
                new int[]{-1, 4, 0, 1, 2, -1, -4}
        );
        List<List<Integer>> leetcode = new Solution().threeSum(
                new int[]{-1, 4, 0, 1, 2, -1, -4}
        );
        System.out.println(my);
        System.out.println(leetcode);
    }

    public List<List<Integer>> getTripletsByZero(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> response = new HashSet<>();
        if (nums.length < 2) {
            throw new RuntimeException("");
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        response.add(
                                Arrays.asList(nums[i],nums[j],nums[k])
                        );
                    }
                }
            }
        }
        return response.stream().toList();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // O(n log n)

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Пропуск одинаковых чисел
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Пропуск одинаковых чисел
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

}
