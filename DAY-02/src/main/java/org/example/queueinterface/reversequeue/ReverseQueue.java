package org.example.queueinterface.reversequeue;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class ReverseQueue {

    // Function to reverse a queue using an ArrayList
    public static <T> void reverseQueue(Queue<T> queue) {
        // Create an ArrayList to store the elements of the queue
        ArrayList<T> list = new ArrayList<>(queue);

        // Clear the original queue
        queue.clear();

        // Add the elements from the ArrayList back to the queue in reversed order
        for (int i = list.size() - 1; i >= 0; i--) {
            queue.add(list.get(i));
        }
    }

    // Main function to test the reverseQueue method
    public static void main(String[] args) {
        // Create a queue and add elements to it
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Print the original queue
        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        // Print the reversed queue
        System.out.println("Reversed Queue: " + queue);
    }
}

