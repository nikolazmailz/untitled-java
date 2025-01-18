package ru.leetcode.algorithms.a_number_after_a_double_reversal_2119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Solution {


    public static void main(String[] args) {
        new Solution().isSameAfterReversals(526);
    }

    public void isSameAfterReversals(int num) {
        Integer reversNum1 = revers(num);
        Integer reversNum2 = revers(reversNum1);
        reversNum2.equals(num);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
        sum.ifPresent(System.out::println); // Вывод: 10
    }

    public static Integer revers(int num) {
        char[] numChars = Integer.valueOf(num).toString().toCharArray();
        char[] revers = new char[numChars.length];

        for (int i = numChars.length - 1; i >= 0; i--) {
            revers[numChars.length - i - 1] = numChars[i];
        }

        String reversLine = new String(revers);
        return Integer.valueOf(reversLine);
    }
}
