package org.example.setinterface.checkiftwosetsareequal;

import java.util.HashSet;
import java.util.Set;

public class ControlClass {
    public static void main(String[] args) {
        CheckEqual obj = new CheckEqual();
        Set<Integer> hs1 = new HashSet<>();
        hs1.add(1);
        hs1.add(2);
        hs1.add(3);

        Set<Integer> hs2 = new HashSet<>();
        hs2.add(3);
        hs2.add(2);
        hs2.add(1);



        System.out.println(obj.checkEqual(hs1,hs2));
    }
}
