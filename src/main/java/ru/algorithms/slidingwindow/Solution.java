package ru.algorithms.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

//        new Solution().sliding(
//                new int[]{3, 2, 8, 4, 2, 3, 4, 5, 1}
//        );

        System.out.println(
        new Solution().lengthOfLongestSubstring(
//                "pwwkew"
                "tmmzuxt"
        ));

    }

    public void sliding(int[] nums) {
        int chain = 1;
        int left = 0;
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (max < chain - left) {
                    max = chain - left;
                }

                chain = chain - map.get(nums[i]);
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
                chain++;
            }

        }

//        System.out.println(chain);
    }

    // "abcabcbb"
    // "pwwkew"
    // "tmmzuxt"
    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int chain = 0;
        int left = 0;
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                if (max < i-1 - left) {
                    max = i - left;
                }
                left = map.get(str[i]);
                chain = chain - left;
                map.put(str[i], i);
            } else {
                map.put(str[i], i);
                chain++;
            }
            if(chain>max){
                max = chain;
            }
        }



        return max;

//        System.out.println(chain);
    }

}
