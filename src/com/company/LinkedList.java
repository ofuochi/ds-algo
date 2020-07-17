package com.company;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    public void addFirst(int value) {
        var node = new Node(value);
        size++;
        if (isEmpty()) {
            first = last = node;
            return;
        }
        node.next = first;
        first = node;

    }

    public void addLast(int value) {
        size++;
        var node = new Node(value);
        if (isEmpty()) {
            first = last = node;
            return;
        }
        last.next = node;
        last = node;
    }

    public void deleteFirst() {
        var node = first.next;
        first.next = null;
        first = node;
        size--;
    }

    public void deleteLast() {
        size--;
        if (first == last) {
            first = last = null;
            return;
        }
        var current = getPrevious(last);
        current.next = null;
        last = current;
    }

    private Node getPrevious(Node node) {
        var current = first;
        var next = first.next;
        while (next != null) {
            if (next == node) {
                return current;
            }
            current = next;
            next = next.next;
        }
        return null;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        var node = first;
        var index = 0;
        while (node != null) {
            if (node.value == value) return index;
            node = node.next;
            index++;
        }
        return -1;
    }

    public int[] toArray() {
        var arr = new int[size];
        var node = first;
        var count = 0;
        while (node != null) {
            arr[count++] = node.value;
            node = node.next;
        }
        return arr;
    }

    private Node reverse(Node node) {
        if (node.next == null) {
            return node;
        }
        var lastNode = reverse(node.next);
        node.next = null;
        lastNode.next = node;
        return node;
    }

    public void reverse() {
//       var lastNode = reverse(first);
//        first = last;
//        last = lastNode;
        var prev = first;
        var curr = first.next;
        while (curr != null) {
            var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        last = first;
        last.next = null;
        first = prev;
    }

    public int getKthFromTheEnd(int k) {
        var x = first;
        var y = first;
        var count = 0;
        while (y != null) {
            y = y.next;
            if (count > k - 1)
                x = x.next;

            count++;
        }
        return x.value;
    }

    public boolean hasLoop(){
        var x = first;
        var y = first;

        while (y != null && y != last && y.next != null){
           x = x.next;
           y = y.next.next;
           if(x == y) return true;
        }
        return false;
    }

    public void printMiddle() {
        if (isEmpty()) return;

        var x = first;
        var y = first;
        while (y != last) {
            var prevX = x;
            x = x.next;
            y = y.next;
            if (y == last) {
                System.out.println(prevX.value + ", " + x.value);
                return;
            }
            y = y.next;
        }
        System.out.println(x.value);
    }
    private boolean isEmpty() {
        return first == null;
    }
    private class Node {
        private final int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }
}
