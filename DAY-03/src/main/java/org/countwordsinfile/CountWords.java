package org.countwordsinfile;

import java.io.*;
import java.util.*;
public class CountWords {

        public static void main(String[] args) {
            // Path to the text file
            String filePath = "src/main/java/org/countwordsinfile/FrequentWords.txt"; // Replace with your file path

            // HashMap to store word counts
            Map<String, Integer> wordCountMap = new HashMap<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                // Read the file line by line
                while ((line = reader.readLine()) != null) {
                    // Split the line into words using regex for non-word characters
                    String[] words = line.split("\\W+");

                    // Update word counts in the HashMap
                    for (String word : words) {
                        if (!word.isEmpty()) { // Ignore empty strings
                            word = word.toLowerCase(); // Convert to lowercase
                            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }

            // Sort the words by frequency in descending order
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCountMap.entrySet());
            sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            // Display the top 5 most frequent words
            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedEntries.size()); i++) {
                Map.Entry<String, Integer> entry = sortedEntries.get(i);
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
