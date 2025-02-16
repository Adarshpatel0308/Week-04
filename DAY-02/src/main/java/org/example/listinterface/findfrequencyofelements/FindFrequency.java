package org.example.listinterface.findfrequencyofelements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
class FindFrequency {
    Map<String, Integer> countFrequency(List<String> sample) {
        Map<String, Integer> hs = new HashMap<>();

        //checking for the list is empty or null
        if (sample == null || sample.isEmpty()) {
            return hs;
        }

        //count the frequency
        for (String str : sample) {
            // Efficiently update the count
            hs.put(str, hs.getOrDefault(str, 0) + 1);
        }
        return hs;
    }
}
