//package ru.leetcode.algorithms.longest_substring_with_at_least_k_repeating_characters_395;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//class Solution {
//
//    public static void main(String[] args) {
//        System.out.println(
//                new Solution().longestSubstring(
//                        "ababacb", 3
//                )
//        );
//    }
//
//    public int longestSubstring(String s, int k) {
//        char[] str = s.toCharArray();
//
//        HashMap<Character, List<Integer>> map = new HashMap();
//
//
//        for (int i = 0; i < str.length; i++) {
//
//            if (map.containsKey(str[i])) {
//                List<Integer> ls = map.get(str[i]);
//                ls.add(i);
//                map.put(str[i], ls);
//            } else {
//                List<Integer> nL = new ArrayList<>();
//                nL.add(i);
//                map.put(str[i], nL);
//                nL.size();
//            }
//
//        }
//
//        List<Integer> r = new ArrayList<>();
//        map.forEach((ke, ve) -> {
//            if (ve.size() >= k) {
//                r.addAll(ve);
//            }
//        });
//
//        List<Integer> r2 = r.stream().sorted().toList();
//
//        int count = 0;
//        int max = 0;
//        for (int i = 0; i < r2.size(); i++) {
//            int j = i;
//
//            while (j < r2.size() - 1) {
//                if(r2.get(j) - (r2.get(j+1) - 1) == 0){
//                    count++;
//                    j++;
//                }
//                else {
//                    break;
//                }
//            }
//            if (max < count) {
//                max = count;
//                max++;
//            }
//            count = 0;
//        }
//
//        if(k==1){
//            max = str.length;
//        }
//
//
//        return max;
//    }
//}