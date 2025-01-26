package ru.leetcode.algorithms.longest_harmonious_subsequence_594;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().findLHS(
//                        new int[]{1,1,1,1}
                        new int[]{1,3,2,2,5,2,3,7}
//                        new int[]{1,2,1,3,0,0,2,2,1,3,3}
                )
        );
    }

    public int findLHS(int[] nums) {
        List<List<Integer>> lis = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if (!(i + 1 < nums.length)) {
                continue;
            }

            List<Integer> lMax = new ArrayList<>();
            List<Integer> lMin = new ArrayList<>();

            int j = i+1;
            lMax.add(nums[i]);
            lMin.add(nums[i]);

            while (j < nums.length){
                if( nums[i] == nums[j] || (nums[i] + 1 == nums[j] ||  nums[i] + 1 == nums[j] - 1) ){
                    lMax.add(nums[j]);
                }
                if( nums[i] == nums[j] || Math.abs(nums[j] - nums[i]) <= 1){
                    lMin.add(nums[j]);
                }
                j++;
            }
            int num = nums[i];

            long count = lMax.stream().filter(p -> p != num ).count();
            if( lMax.size() != count && count != 0 ){
                lis.add(lMax);
            }

            count = lMin.stream().filter(p -> p != num ).count();
            if( lMin.size() != count && count != 0 ){
                lis.add(lMin);
            }
        }


        List<Integer> largestList = lis.stream()
                .max(Comparator.comparingInt(List::size))
                .orElse(Collections.emptyList());

        return largestList.size();
    }

//    public int findLHS(int[] nums) {
//        List<List<Integer>> lis = new ArrayList<>();
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for(int i = 0; i < nums.length; i++){
//            if (!(i + 1 < nums.length)) {
//                continue;
//            }
//            int right = i+1;
//            List<Integer> loopList = new ArrayList<>();
//            loopList.add(nums[i]);
//            while (right < nums.length){
//                if(Math.abs(nums[i] - nums[right] ) <= 1 ){
//                    loopList.add(nums[right]);
//                }
//                right++;
//            }
//
//            Integer x = loopList.getFirst();
//
//            if(0 < loopList.stream().filter( (p ) -> !x.equals(p)).count() ){
//                lis.add(loopList);
//            }
//
//        }
//
//        List<Integer> largestList = lis.stream()
//                .max(Comparator.comparingInt(List::size))
//                .orElse(Collections.emptyList());
//
//        return largestList.size();
//    }
}
