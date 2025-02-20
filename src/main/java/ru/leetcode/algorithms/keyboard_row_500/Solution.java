package ru.leetcode.algorithms.keyboard_row_500;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class Solution {



    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution().findWords(
                        new String[]{"Hello", "Alaska", "Dad", "Peace"}
                ))
        );

    }


    public String[] findWords(String[] words) {

        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        Set<Character> arr1 = row1.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(HashSet::new));
        Set<Character> arr2 = row2.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(HashSet::new));
        Set<Character> arr3 = row3.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(HashSet::new));

        List<String> wordsResonse = new ArrayList<>();
        for(String word : words){
            boolean inRow1 = true;
            boolean inRow2 = true;
            boolean inRow3 = true;

            for(Character s : word.toLowerCase().toCharArray()){
                if(!arr1.contains(s)){
                    inRow1 = false;
                }

                if(!arr2.contains(s)){
                    inRow2 = false;
                }

                if(!arr3.contains(s)){
                    inRow3 = false;
                }
            }

            if(inRow1){ wordsResonse.add(word);}
            if(inRow2){ wordsResonse.add(word);}
            if(inRow3){ wordsResonse.add(word);}
        }

        String[] stringArray = new String[wordsResonse.size()];
        for (int i = 0; i < wordsResonse.size(); i++) {
            stringArray[i] = (String) wordsResonse.get(i);
        }

        return stringArray;

    }


}
