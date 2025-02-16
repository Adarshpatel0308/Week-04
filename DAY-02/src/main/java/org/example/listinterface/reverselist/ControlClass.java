package org.example.listinterface.reverselist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ControlClass {
    public static void main(String[] args) {
        ReverseList obj = new ReverseList();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Example input for LinkedList
        List<Integer> linkedList = new LinkedList<>(list);

        // Reverse both lists
        System.out.println("Original ArrayList: " + list);
        obj.reverseList(list);
        System.out.println("Reversed ArrayList: " + list);

        System.out.println("Original LinkedList: " + linkedList);
        obj.reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);

    }
}
