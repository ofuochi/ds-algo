package com.company;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        var arr = new MyLinkedList();
        arr.addFirst(1);
        arr.addFirst(0);
        arr.addLast(2);
        arr.addLast(3);

        System.out.println(arr.contains(-1));
    }


}
