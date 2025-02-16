package org.example.mapinterface.invertmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertedMap {

        public static void main(String[] args) {
            // Original map
            Map<String, Integer> originalMap = new HashMap<>();
            originalMap.put("A", 1);
            originalMap.put("B", 2);
            originalMap.put("C", 1);

            // Invert the map
            Map<Integer, List<String>> invertedMap = invertMap(originalMap);

            // Print the inverted map
            System.out.println("Inverted Map: " + invertedMap);
        }

        public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
            Map<V, List<K>> invertedMap = new HashMap<>();

            // Iterate through the original map
            for (Map.Entry<K, V> entry : originalMap.entrySet()) {
                K key = entry.getKey();
                V value = entry.getValue();

                // If the value is not already in the inverted map, create a new list
                invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);

//                if (!invertedMap.containsKey(value)) {
//                    invertedMap.put(value, new ArrayList<>());
//                }
//                invertedMap.get(value).add(key);
            }

            return invertedMap;
        }
    }
