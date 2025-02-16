package org.example.mapinterface.findkeywithhighestvalue;

import java.util.Map;
import java.util.HashMap;
public class KeyWithHighestValue {
        public static void main(String[] args) {
            // Input map
            Map<String, Integer> map = new HashMap<>();
            map.put("A", 10);
            map.put("B", 20);
            map.put("C", 15);

            // Find the key with the maximum value
            String maxKey = findKeyWithMaxValue(map);

            // Print the result
            System.out.println("Key with the maximum value: " + maxKey);
        }

        public static String findKeyWithMaxValue(Map<String, Integer> map) {
            String maxKey = null; // To store the key with the maximum value
            int maxValue = Integer.MIN_VALUE; // To store the maximum value

            // Iterate through the map
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();

                // Update maxKey and maxValue if the current value is greater
                if (value > maxValue) {
                    maxValue = value;
                    maxKey = key;
                }
            }

            return maxKey;
        }
    }
