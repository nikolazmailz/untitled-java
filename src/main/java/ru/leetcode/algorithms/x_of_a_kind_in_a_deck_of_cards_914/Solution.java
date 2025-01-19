package ru.leetcode.algorithms.x_of_a_kind_in_a_deck_of_cards_914;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Math.max;

/**
 * 914. X of a Kind in a Deck of Cards
 * Easy
 * Topics
 * Companies
 * You are given an integer array deck where deck[i] represents the number written on the ith card.
 * <p>
 * Partition the cards into one or more groups such that:
 * <p>
 * Each group has exactly x cards where x > 1, and
 * All the cards in one group have the same integer written on them.
 * Return true if such partition is possible, or false otherwise.
 * <p>
 * У нас есть массив deck, где каждая запись deck[i] представляет число, написанное на карте.
 * Необходимо проверить, можно ли разделить все карты на одну или несколько групп
 * таким образом, чтобы:
 * <p>
 * В каждой группе было ровно x карт, где
 * -> 𝑥 > 1
 * -> x > 1.
 * -> Все карты в одной группе имели одинаковое число.
 * Если такое разбиение возможно, вернуть true, иначе вернуть false.
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().hasGroupsSizeX(
                new int[]{1,2,3,4,4,3,2,1}
        );
    }

    public boolean hasGroupsSizeX(int[] decks) {

        boolean answer = false;

//        Map<Integer, Integer> countMap = new HashMap<>();
//
//        for (int deck : decks) {
//            countMap.put(deck, countMap.getOrDefault(deck, 0) + 1);
//        }

//        countMap.forEach((key, value) ->
//                System.out.println("Значение " + key + " встречается " + value + " раз(а)")
//        );

        Map<Integer, Long> countMap = Arrays.stream(decks)
                .boxed() // Преобразуем int[] в Stream<Integer>
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        int maxCountNumber = countMap.values().stream().max(Long::compareTo).orElseThrow().intValue();

        if(countMap.values().stream().filter(c -> c % maxCountNumber != 0).toList().isEmpty()){
            answer = true;
        }


        return answer;

    }
}