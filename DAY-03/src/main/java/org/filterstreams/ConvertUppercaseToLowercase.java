package org.filterstreams;

import java.io.*;
public class ConvertUppercaseToLowercase    {
        public static void main(String[] args) {
            // Define input and output file paths
            String inputFilePath = "src/main/java/org/filterstreams/beforelowercase.txt"; // Replace with your input file path
            String outputFilePath = "src/main/java/org/filterstreams/tolowercase.txt"; // Replace with your output file path

            try (
                    // Create FileReader and BufferedReader for reading the input file
                    FileReader fileReader = new FileReader(inputFilePath);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    // Create FileWriter and BufferedWriter for writing to the output file
                    FileWriter fileWriter = new FileWriter(outputFilePath);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            ) {
                String line;
                // Read each line from the input file
                while ((line = bufferedReader.readLine()) != null) {
                    // Convert the line to lowercase
                    String lowerCaseLine = line.toLowerCase();
                    // Write the lowercase line to the output file
                    bufferedWriter.write(lowerCaseLine);
                    bufferedWriter.newLine(); // Add a newline after each line
                }
                System.out.println("File conversion completed successfully!");
            } catch (IOException e) {
                // Handle any IO exceptions
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }
