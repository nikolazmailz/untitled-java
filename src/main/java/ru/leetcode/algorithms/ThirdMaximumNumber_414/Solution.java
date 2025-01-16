package ru.leetcode.algorithms.ThirdMaximumNumber_414;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
//        int[] nums = {3,2,1};
        int[] nums = {2,2,3,1};
//        int[] nums = {1,2};
        new Solution().thirdMax(nums);
    }

    public int thirdMax(int[] nums) {
        int max1 = 0, max2 = 0, max3 = 0;
        int maxR = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num >= max1){
                if(num > max2){
                    max2 = max1;
                }
                max1 = num;
                maxR = num;
            } else if(num < max1 && num >= max2) {
                max2 = num;
            } else if(num < max2 && num >= max3){
                max3 = num;
                maxR = num;
            }
        }
        return maxR;
//        int i1 = Arrays.stream(nums).max().orElseThrow();
//        nums = Arrays.stream(nums)
//                .filter(num -> num != i1).toArray();
//        if(nums.length == 0){
//            return i1;
//        }
//        int i2 = Arrays.stream(nums).max().orElseThrow();
//        nums = Arrays.stream(nums)
//                .filter(num -> num != i2).toArray();
//        if(nums.length == 0){
//            return i1;
//        }
//        return Arrays.stream(nums).max().orElseThrow();
    }
}
