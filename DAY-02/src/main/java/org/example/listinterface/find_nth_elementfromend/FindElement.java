package org.example.listinterface.find_nth_elementfromend;

import java.util.LinkedList;
import java.util.Collections;

class FindElement {
    char findElement(LinkedList<Character> sampleList, int position){
        Collections.reverse(sampleList);
        char ch = sampleList.get(position-1);

        return ch;
    }
}
