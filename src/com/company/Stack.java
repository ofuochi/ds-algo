package com.company;

public class Stack {
    private char[] elements = new char[5];
    private int count = 0;

    public void push(char e) {
        if (isFull()) {
            var arr = new char[count * 2];
            for (int i = 0; i < count; i++) {
                arr[i] = elements[i];
            }
            elements = arr;
        }
        elements[count++] = e;
    }

    public char pop(){
        return elements[--count];
    }
    public char peek(){
        return elements[count-1];
    }
    public boolean isEmpty(){
        return count == 0;
    }

    private boolean isFull() {
        return count == elements.length;
    }
}
