package com.company;

import java.util.Arrays;

public class ArrayQueue {
    private int front;
    private int end;
    private int count;
    private int[] items;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();


        items[count++] = item;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        count--;
        var item = items[0];

        for (int i = 0; i < count; i++) {
            items[i] = items[i + 1];
        }

        return item;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(items, 0, count));
    }
}
