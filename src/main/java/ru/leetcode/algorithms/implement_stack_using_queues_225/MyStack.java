package ru.leetcode.algorithms.implement_stack_using_queues_225;

import java.util.LinkedList;
import java.util.List;

public class MyStack {

    List<Integer> myStack = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        myStack.add(x);
    }

    public int pop() {
        int last = myStack.getLast();
        myStack.removeLast();
        return last;
    }

    public int top() {
        return myStack.getLast();
    }

    public boolean empty() {
        return myStack.isEmpty();
    }
}
