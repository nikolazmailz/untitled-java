package ru.leetcode.algorithms.isomorphic;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

    public static void main(String[] args) {

        System.out.println(
                new Isomorphic().isIsomorphic("paper", "title")
        );

    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToTMap = new HashMap<>();
        Map<Character, Character> tToSMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // Проверка отображения s -> t
            if (sToTMap.containsKey(sChar)) {
                if (sToTMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                sToTMap.put(sChar, tChar);
            }

            // Проверка отображения t -> s
            if (tToSMap.containsKey(tChar)) {
                if (tToSMap.get(tChar) != sChar) {
                    return false;
                }
            } else {
                tToSMap.put(tChar, sChar);
            }
        }

        return true;
    }


//    public boolean isIsomorphic(String s, String t) {
//        // Create arrays to store the index of characters in both strings
//        int[] indexS = new int[200]; // Stores index of characters in string s
//        int[] indexT = new int[200]; // Stores index of characters in string t
//
//        // Get the length of both strings
//        int len = s.length();
//
//        // If the lengths of the two strings are different, they can't be isomorphic
//        if(len != t.length()) {
//            return false;
//        }
//
//        // Iterate through each character of the strings
//        for(int i = 0; i < len; i++) {
//            // Check if the index of the current character in string s
//            // is different from the index of the corresponding character in string t
//            if(indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
//                return false; // If different, strings are not isomorphic
//            }
//
//            // Update the indices of characters in both strings
//            indexS[s.charAt(i)] = i + 1; // updating index of current character
//            indexT[t.charAt(i)] = i + 1; // updating index of current character
//        }
//
//        // If the loop completes without returning false, strings are isomorphic
//        return true;
//    }
}
