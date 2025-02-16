package org.example.listinterface.removeduplicateswhilepreservingorder;

import java.util.ArrayList;
import java.util.List;

public class ControlClass {
    public static void main(String[] args) {

        RemoveDuplicate rd = new RemoveDuplicate();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(rd.removeDuplicate(list));
    }
}
