package org.example.setinterface.findsubsets;

import java.util.HashSet;
import java.util.Set;

public class ControlClass {
    public static void main(String[] args) {
        FindSubsets obj = new FindSubsets();
        // Define Set1
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);

        // Define Set2
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Check if Set1 is a subset of Set2
        boolean isSubset = obj.checkSubset(set1, set2);

        // Output the result
        System.out.println("Set1 is a Subset of Set2 ?? " + isSubset);
    }
}
