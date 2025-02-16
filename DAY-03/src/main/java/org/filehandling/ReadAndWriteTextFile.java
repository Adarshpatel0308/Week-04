package org.filehandling;

import java.io.*;

public class ReadAndWriteTextFile {
    public static void main(String[] args) {
        String sourceFile = "Day03week04.txt"; // Path to the source file
        String destinationFile = "new 1.txt"; // Path to the destination file

        // Check if the source file exists
        File file = new File(sourceFile);
        if (!file.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        // Try-with-resources to automatically close streams
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            // Read data from the source file and write to the destination file
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
