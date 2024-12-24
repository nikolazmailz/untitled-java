package ru.leetcode.lengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        String s = "pwwkew";
//        String s = "qwerqtyuio";
        String s = "asdaqweratyzxc";

        System.out.println(new Main().lengthOfLongestSubstring(s));
        System.out.println(new Main().lengthOfLongestSubstring(s, true));


        List<String> list = List.of("apple", "banana", "cherry");


//        list.stream().filter()


    }


    // asdaqweratyzxc
    public int lengthOfLongestSubstring(String s, Boolean b) {
        HashMap<Character, Integer> hs = new HashMap<>();
        int big = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (hs.containsKey(a)) {
                hs.get(a); //вытаскиваю индекс
                // прибавляю к нему единицу
                // сравниваю с j по умолчанию 0 если j > ? j : index+1
                j = j > hs.get(a) + 1 ? j : hs.get(a) + 1;
            }
            hs.put(a, i); // a 3
            // 0 = 0 >
            big = big > i - j + 1 ? big : i - j + 1;
            System.out.println("big " + big);
        }

        return big;
    }


    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        List<String> coll = new ArrayList<>();
        char[] sCharArray = s.toCharArray();

        for (int i = 0; i < sCharArray.length; i++) {
            if (coll.contains(String.valueOf(sCharArray[i]))) {
                i--;
                coll = new ArrayList<>();
            } else {
                coll.add(String.valueOf(sCharArray[i]));
                if (l < coll.size()) {
                    l = coll.size();
                }
            }
        }
        return l;
    }
}
