package org.example.setinterface.symmetricdifference;

import java.util.HashSet;
import java.util.Set;

public class ControlClass {
    public static void main(String[] args) {
        SymmetricDifference obj = new SymmetricDifference();
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println(obj.symmetricDifference(set1,set2));
    }
}
