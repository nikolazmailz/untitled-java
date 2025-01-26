package ru.algorithms.palindrom;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().reverseArray(
//                        "A man, a plan, a canal: Panama"
                        "race a car"
                )
        );
    }

    public static boolean reverseArray(String s) {
        String s2 = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String[] sArray = s2.split("");
        System.out.println(s2);
        int left = 0, right = sArray.length - 1;
        boolean isP = true;
        while (left < right) {
            if(!sArray[left].equals(sArray[right])){
                isP = false;
                break;
            }
            left++;
            right--;
        }
        return isP;
    }

    public boolean isPalindrome(String s) {
        String s2 = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        System.out.println(s2);

        String[] sArray = s2.split("");

        int middle;
        int x = sArray.length % 2;
        if( x != 0 ){
            middle = (sArray.length - x) /2 ;
        } else {
            middle = sArray.length / 2;
        }
        boolean palindrome = true;
        for(int i = 0; i < middle; i++){

            if (!sArray[i].equals(sArray[sArray.length - 1 - i])) {
                System.out.println(sArray[i] + " " + i);
                System.out.println(sArray[sArray.length - 1 - i] + " " + (sArray.length - 1 - i));
                palindrome = false;
                break;
            }
        }

        return palindrome;
    }
}