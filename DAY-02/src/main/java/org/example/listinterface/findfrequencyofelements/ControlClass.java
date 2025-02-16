package org.example.listinterface.findfrequencyofelements;

import java.util.List;
import java.util.Map;

public class ControlClass {
    public static void main(String[] args) {

        List<String> inputList = List.of("apple", "banana", "apple", "orange");
        FindFrequency ff = new FindFrequency();
        Map<String, Integer> frequencies = ff.countFrequency(inputList);
        System.out.println(frequencies);

    }
}
