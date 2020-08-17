package com.company;

public class MyLinkedList {
    private Node first;
    private Node last;
    public int size;

    private class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void addFirst(int item) {
        var node = new Node(item);
        size++;
        if (isEmpty()) {
            first = last = node;
            return;
        }

        node.next = first;
        first = node;
    }

    public void addLast(int item) {
        var node = new Node(item);
        size++;
        if (isEmpty()) {
            first = last = node;
            return;
        }

        last.next = node;
        last = node;
    }

    public void deleteFirst() {
        if (isEmpty()) return;

        Node next = first.next;
        first.next = null;
        first = next;
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) return;
        size--;
        if (first.next == null) {
            first = last = null;
            return;
        }
        Node curr = first;
        Node prev = first;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        last = prev;
    }

    public boolean contains(int item) {
        return indexOf(item) > 0;
    }

    public int indexOf(int item) {
        var count = 0;
        Node node = first;
        while (node != null) {
            if (node.value == item)
                return count;
            node = node.next;
            count++;
        }
        return -1;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
