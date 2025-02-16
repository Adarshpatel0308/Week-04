package org.example.listinterface.find_nth_elementfromend;

import java.util.LinkedList;
import java.util.List;

public class ControlClass {
    public static void main(String[] args) {
        LinkedList<Character> linkedList = new LinkedList<>();
        FindElement obj = new FindElement();
        linkedList.add('A');
        linkedList.add('B');
        linkedList.add('C');
        linkedList.add('D');
        linkedList.add('E');
       char result = obj.findElement(linkedList,2);
        System.out.println("The nth element from end : "+result);

    }
}
