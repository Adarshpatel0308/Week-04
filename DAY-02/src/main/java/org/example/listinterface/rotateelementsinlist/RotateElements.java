package org.example.listinterface.rotateelementsinlist;

import java.util.ArrayList;
import java.util.List;

class RotateElements {
    List<Integer> rotateElements(List<Integer> sampleList, int steps) {
        int length = sampleList.size();

        int rotateBy = steps % length;

        List<Integer> rotateList = new ArrayList<>();

        for (int i = rotateBy; i < length; i++) {

            rotateList.add(sampleList.get((i)));

        }
        for (int i = 0; i < rotateBy; i++) {
            rotateList.add(sampleList.get(i));
        }

        return rotateList;

    }
}
