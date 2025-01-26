package ru.leetcode.algorithms.count_complete_tree_nodes_222;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * 222. Count Complete Tree Nodes
 * Easy
 * Topics
 * Companies
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * According to Wikipedia, every level, except possibly the last, is completely filled in a
 * complete binary tree, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Design an algorithm that runs in less than O(n) time complexity.
 *
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        var sol = new Solution();

        // Создаем корень
        TreeNode root = sol.new TreeNode(arr[0]);

        // Используем очередь для заполнения дерева
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Добавляем корень в очередь

        int i = 1;
        while (i < arr.length) {
            TreeNode currentNode = queue.poll(); // Берем текущий узел из очереди

            // Заполняем левый дочерний узел
            if (i < arr.length) {
                currentNode.left = sol.new TreeNode(arr[i]);
                queue.add(currentNode.left); // Добавляем в очередь левый узел
                i++;
            }

            // Заполняем правый дочерний узел
            if (i < arr.length) {
                currentNode.right = sol.new TreeNode(arr[i]);
                queue.add(currentNode.right); // Добавляем в очередь правый узел
                i++;
            }
        }
        System.out.println(sol.countNodes(root));
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return  1+left+right;
    }
}

