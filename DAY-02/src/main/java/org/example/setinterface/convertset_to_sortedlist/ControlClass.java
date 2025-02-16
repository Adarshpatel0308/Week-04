package org.example.setinterface.convertset_to_sortedlist;

import java.util.HashSet;
import java.util.Set;

public class ControlClass {
    public static void main(String[] args) {
        Convert obj = new Convert();
        Set<Integer> hs = new HashSet<>();
        hs.add(5);
        hs.add(3);
        hs.add(9);
        hs.add(1);

        System.out.println(obj.SortedList(hs));

    }
}
