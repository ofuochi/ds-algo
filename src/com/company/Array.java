package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    private int count;
    private int[] arr;

    public Array(int length) {
        this.arr = new int[length];
    }

    public void insert(int item) {
        if (arr.length == this.count) {
            expandArray();
        }
        this.arr[this.count++] = item;
    }

    private void expandArray() {
        var arrCopy = new int[this.arr.length * 2];
        for (int i = 0; i < this.arr.length; i++)
            arrCopy[i] = this.arr[i];

        this.arr = arrCopy;

    }

    public int max() {
        var max = arr[0];
        for (int item : arr) {
            if (item > max) max = item;
        }
        return max;
    }

    public int[] intersect(int[] items) {
        Integer[] data = Arrays.stream(items).boxed().toArray(Integer[]::new);
        var intersect = new ArrayList<Integer>();
        for (int i = 0; i < this.count; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[j] != null && arr[i] == data[j]) {
                    intersect.add(arr[i]);
                    data[j] = null;
                    break;
                }
            }
        }
        return intersect.stream().mapToInt(i -> i).toArray();
    }

    public int[] reverse() {
        var reversed = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            reversed[count - 1 - i] = arr[i];
        }
        return reversed;
    }

    public void insertAt(int item, int index) {
        if (arr.length == this.count) {
            expandArray();
        }
        var tmp = arr[index];
        arr[index] = item;

        for (int i = index + 1; i < arr.length - 1; i++) {
            var next = arr[i];
            arr[i] = tmp;
            tmp = next;
        }
        count++;
    }

    public void removeAt(int index) {
        if (index >= count || index < 0)
            throw new IllegalArgumentException();
        for (int i = index; i < this.count; i++) {
            if (i + 1 == count) break;
            this.arr[i] = this.arr[i + 1];
        }
        this.count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (this.arr[i] == item) return i;
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < this.count; i++) {
            System.out.println(this.arr[i]);
        }
    }
}
