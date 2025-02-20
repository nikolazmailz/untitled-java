package ru.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Обход дерева в ширину (BFS):");
        tree.bfs();
    }

}


class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Реализация BFS
    void bfs() {
        if (root == null) {
            System.out.println("Дерево пустое");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root); // Добавляем корень в очередь

        while (!queue.isEmpty()) {
            Node current = queue.poll(); // Извлекаем узел из очереди
            System.out.print(current.value + " "); // Обрабатываем узел

            // Добавляем потомков в очередь
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }
}