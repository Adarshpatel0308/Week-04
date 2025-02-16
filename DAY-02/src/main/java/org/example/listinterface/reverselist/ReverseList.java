package org.example.listinterface.reverselist;

import java.util.List;

class ReverseList {

    // Method to reverse a list
    static void reverseList(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            // Swap elements at i and (size - i - 1)
            int temp = list.get(i);
            list.set(i, list.get(size - i - 1));
            list.set(size - i - 1, temp);
        }
    }

        }

