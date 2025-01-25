package ru.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TwoSumII.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        var left = 1;
        var right = nums.length;

        while (left < right) {
            var nLeft = nums[left-1];
            var nRight = nums[right-1];

            if (nLeft + nRight == target) {
                return new int[]{left, right};
            } else if (nLeft + nRight < target) {
                left++;
            } else {
                right--;
            }

        }

        throw new IllegalArgumentException("No solution found");
    }
}
