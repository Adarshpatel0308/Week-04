package org.example.mapinterface.mergetwomaps;

import java.util.HashMap;
import java.util.Map;
public class MergeTwoMaps {
        public static void main(String[] args) {
            // Input maps
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("A", 1);
            map1.put("B", 2);

            Map<String, Integer> map2 = new HashMap<>();
            map2.put("B", 3);
            map2.put("C", 4);

            // Merge the maps
            Map<String, Integer> mergedMap = mergeMaps(map1, map2);

            // Print the merged map
            System.out.println("Merged Map: " + mergedMap);
        }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1); // Copy map1 to mergedMap

        // Iterate through map2
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            // If the key already exists in mergedMap, sum the values
            if (mergedMap.containsKey(key)) {
                mergedMap.put(key, mergedMap.get(key) + value);
            } else {
                // Otherwise, add the key-value pair
                mergedMap.put(key, value);
            }
        }

        return mergedMap;
    }
}
