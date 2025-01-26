package ru.algorithms.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sol4 {


    public static void main(String[] args) {
        System.out.println(
                new Sol4().lengthOfLongestSubstring("pwwkew")
        );
        // abcabcbb
        // pwwkew
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
//        List<Character> lc = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;

        for (int i = 0; i < chars.length; i++) {

            if(map.containsKey(chars[i])){
                left = Math.max(left, map.get(chars[i]) + 1);
            }

            map.put(chars[i], i);

            maxLength = Math.max(maxLength, i - left + 1);
        }


//        for (int i = 0; i < chars.length; i++) {
//            if(!lc.contains(chars[i])){
//                lc.add(chars[i]);
//                maxLength = Math.max(maxLength, lc.size());
//            } else {
//                int removeIndex = lc.indexOf(chars[i]);
//                maxLength = Math.max(maxLength, lc.size());
//                int j = 0;
//                while ( j <= removeIndex){
//                    lc.removeFirst();
//                    j++;
//                }
//                lc.add(chars[i]);
//            }
//        }

//        maxLength = Math.max(maxLength, lc.size());
//        for (int i = 0; i < chars.length; i++) {
//            if (!map.containsKey(chars[i])) {
//                map.put(chars[i], i);
//                maxLength = Math.max(maxLength, map.size());
//            } else {
//                int removeIndex = map.get(chars[i]);
//                maxLength = Math.max(maxLength, map.size());
//                map.entrySet().removeIf(entry -> entry.getValue() <= removeIndex);
//                map.put(chars[i], i);
//            }
//
//        }

        return maxLength;
    }

}
