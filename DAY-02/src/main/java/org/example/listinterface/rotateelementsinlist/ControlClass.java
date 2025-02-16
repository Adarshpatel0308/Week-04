package org.example.listinterface.rotateelementsinlist;

import java.util.ArrayList;
import java.util.List;

public class ControlClass {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        RotateElements re = new RotateElements();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        List<Integer> rotated = re.rotateElements(list, 2);
        System.out.println(rotated); // Output: [30, 40, 50, 10, 20]
    }
}
