package ru.leetcode.algorithms.contains_duplicate_ii;

import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        boolean s = new Solution().containsNearbyDuplicate(
                new int[]{1,2,3,1}, 3
        );
        System.out.println(s);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++){

            if(map.containsKey(nums[i])){

                if(i - map.get(nums[i]) <= k){
                    return true;
                }
            }

            map.put(nums[i], i);

        }

        return false;
    }
}
