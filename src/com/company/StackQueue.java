package com.company;

import java.util.Arrays;
import java.util.Stack;

public class StackQueue {
    private Stack<Integer> items = new Stack<>();

    public void enqueue(int item) {
        items.push(item);
    }

    public int dequeue() {
        Stack<Integer> tempItems = new Stack<>();
        while (!items.isEmpty()) tempItems.push(items.pop());
        var item = tempItems.pop();
        while (!tempItems.isEmpty()) items.push(tempItems.pop());
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(items.toArray());
    }
}
