package ru.leetcode.algorithms.minimum_cost_to_move_chips_to_the_same_position_1217;

/**
 * 1217. Minimum Cost to Move Chips to The Same Position
 * Easy
 * Topics
 * Companies
 * Hint
 * We have n chips, where the position of the ith chip is position[i].
 * <p>
 * We need to move all the chips to the same position.
 * In one step, we can change the position of the ith chip from position[i] to:
 * <p>
 * position[i] + 2 or position[i] - 2 with cost = 0.
 * position[i] + 1 or position[i] - 1 with cost = 1.
 * Return the minimum cost needed to move all the chips to the same position.
 * <p>
 * 1217. Минимальная стоимость перемещения фишек в ту же позицию
 * <p>
 * У нас есть n фишек, где позиция i-й фишки — position[i].
 * <p>
 * Нам нужно переместить все фишки в ту же позицию.
 * За один шаг мы можем изменить позицию i-й фишки с position[i] на:
 * <p>
 * position[i] + 2 или position[i] - 2 со стоимостью = 0.
 * position[i] + 1 или position[i] - 1 со стоимостью = 1.
 * Верните минимальную стоимость, необходимую для перемещения всех фишек в ту же позицию.
 */
public class Solution {

    public static void main(String[] args) {
        int i = new Solution().minCostToMoveChips(
                new int[]{1,2,3}
        );
        System.out.println(i);
    }

    public int minCostToMoveChips(int[] position) {
        int c = 0; // chet
        int n = 0; // nechect

        for (int chsilo : position) {
            if (chsilo % 2 == 0) {
                c++;
            } else {
                n++;
            }
        }

        if (c > n) {
            return n;
        } else {
            return c;
        }

    }
}
