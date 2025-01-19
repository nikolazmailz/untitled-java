package ru.leetcode.algorithms.longest_substring_without_repeating_characters_3;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring(
                "abcqwecabcqbb"
        );
    }

    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();

        List<Character> full = new LinkedList<>();
        Map<Integer, Long> myMap = new HashMap<>();
        int k = 0;

        for (int i = 0; i < str.length; i++) {

            if (!full.contains(str[i])) {
                full.add(str[i]);
            } else {
                myMap.put(k, full.stream().count());
                k++;
                while (!full.isEmpty() && full.getFirst() < str[i]) {
                    full.removeFirst();
                }
            }

        }
        Long countChain = 0L;

        for (Map.Entry<Integer, Long> entry : myMap.entrySet()) {
            if (entry.getValue() > countChain) {
                countChain = entry.getValue();
            }
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        return countChain.intValue();
    }
}
