package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray {
    private int count;
    private int[] items;

    public MyArray(int capacity) {
        items = new int[capacity];
    }

    public void insert(int item) {
        if (isFull()) {
            expand();
        }
        items[count++] = item;
    }

    private void expand() {
        var arr = new int[count * 2];
        for (int i = 0; i < items.length; i++) {
            arr[i] = items[i];
        }
        items = arr;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        for (int i = index; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) return i;
        }
        return -1;
    }

    public int max() {
        var max = items[0];
        for (int i = 1; i < count; i++) {
            if (max < items[i]) max = items[i];
        }
        return max;
    }

    public int[] intersect(int[] items) {
        var arr = new int[items.length];
        int count = 0;
        for (int i = 0; i < this.count; i++) {
            for (int j = 0; j < items.length; j++) {
                if (this.items[i] == items[j]) {
                    arr[count++] = items[j];
                    items[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(arr, 0, count);
    }

    public int[] reverse() {
        var arr = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            arr[count - 1 - i] = items[i];
        }
        return arr;
    }

    public void insertAt(int index, int item) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        if (isFull()) expand();

        for (int i = count - 1; i >= index; i--) {
            items[i + 1] = items[i];
        }
        items[index] = item;
        count++;
    }

    private boolean isFull() {
        return count == items.length;
    }
}
