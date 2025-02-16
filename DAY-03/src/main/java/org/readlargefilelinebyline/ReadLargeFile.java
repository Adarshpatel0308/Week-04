package org.readlargefilelinebyline;

import java.io.*;
public class ReadLargeFile {

        public static void main(String[] args) {
            // Path to the large text file
            String filePath = "src/main/java/org/readlargefilelinebyline/LargeFile.txt"; // Replace with your file path

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                // Read the file line by line
                while ((line = reader.readLine()) != null) {
                    // Check if the line contains the word "error"
                    if (line.toLowerCase().contains("error")) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        }
    }
