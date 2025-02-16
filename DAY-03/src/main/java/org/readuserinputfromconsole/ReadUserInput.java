package org.readuserinputfromconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileWriter;

public class ReadUserInput {
    public static void main(String[] args) {
        String destinationFile = "src/main/java/org/readuserinputfromconsole/ReadInputFromUser.txt.txt";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Variables to store user input
        String name = "";
        String age = "";
        String favoriteLanguage = "";

        try {
            // Prompt the user for their name
            System.out.print("Enter your name: ");
            name = reader.readLine();

            // Prompt the user for their age
            System.out.print("Enter your age: ");
            age = reader.readLine();

            // Prompt the user for their favorite programming language
            System.out.print("Enter your favorite programming language: ");
            favoriteLanguage = reader.readLine();

            // Save the user input to a file
            try (FileWriter writer = new FileWriter(destinationFile)) {
                writer.write("Name: " + name + "\n");
                writer.write("Age: " + age + "\n");
                writer.write("Favorite Programming Language: " + favoriteLanguage + "\n");
            }

            System.out.println("Your information has been saved to " + destinationFile);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the BufferedReader
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the reader: " + e.getMessage());
            }
        }
    }
    }
