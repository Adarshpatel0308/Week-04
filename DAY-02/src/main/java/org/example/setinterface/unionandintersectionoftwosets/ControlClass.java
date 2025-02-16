package org.example.setinterface.unionandintersectionoftwosets;

import java.util.HashSet;
import java.util.Set;

public class ControlClass {
    public static void main(String[] args) {
        UnionAndIntersection obj = new UnionAndIntersection();
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Union Of Sets");
        System.out.println(obj.unionOfSets(set1,set2));
        System.out.println("Intersection Of Sets");
        System.out.println(obj.intersectionOfSets(set1,set2));
    }
}
