package org.example.queueinterface.generatebinarynumberusingqueue;

import java.util.Queue;
import java.util.LinkedList;
public class GenerateBinaryNumbers {

        // Function to generate the first N binary numbers using a queue
        public static void generateBinaryNumbers(int N) {
            // Create a queue to hold binary numbers as strings
            Queue<String> queue = new LinkedList<>();

            // Add the first binary number "1" to the queue
            queue.add("1");

            // Generate and print the first N binary numbers
            for (int i = 0; i < N; i++) {
                // Dequeue the front element (binary number)
                String current = queue.poll();

                // Print the current binary number
                System.out.print(current + " ");

                // Append "0" and "1" to the current binary number and enqueue them
                queue.add(current + "0");
                queue.add(current + "1");
            }
        }

        // Main function to test the generateBinaryNumbers method
        public static void main(String[] args) {
            int N = 6;  // Define how many binary numbers you want
            System.out.println("The first " + N + " binary numbers are:");
            generateBinaryNumbers(N);  // Generate and print the first N binary numbers
        }
    }
