package ru.interview.yandex;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(
                Arrays.toString(new Solution().squareArray(
                        new int[]{-5,-3,2,4,7,8}
                ))
        );
    }

    public int[] squareArray(int[] nums){
        int i1 = 0;
        int i2 = nums.length-1;
        int[] nums2 = new int[nums.length];

        while ( i1 <= i2) {
            int n1 = nums[i1]*nums[i1];
            int n2 =  nums[i2]*nums[i2];
            if(n1 > n2){
                nums2[i2-i1] = n1;
                i1++;
            } else {
                nums2[i2-i1] = n2;
                i2--;
            }
        }
        return nums2;
    }
}
