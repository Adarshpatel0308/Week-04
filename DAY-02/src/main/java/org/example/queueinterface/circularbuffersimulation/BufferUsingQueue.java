package org.example.queueinterface.circularbuffersimulation;

import java.util.Queue;
import java.util.LinkedList;

class CircularBuffer {
    private Queue<Integer> queue;
    private int maxSize;

    // Constructor to initialize the circular buffer with a fixed size
    public CircularBuffer(int size) {
        this.maxSize = size;
        this.queue = new LinkedList<>();
    }

    // Add an element to the buffer
    public void add(int value) {
        if (queue.size() == maxSize) {
            queue.poll(); // Remove the oldest element if the buffer is full
        }
        queue.offer(value); // Add the new element
    }

    // Remove and return the oldest element from the buffer
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Buffer is empty!");
        }
        return queue.poll();
    }

    // Check if the buffer is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Check if the buffer is full
    public boolean isFull() {
        return queue.size() == maxSize;
    }

    // Get the current size of the buffer
    public int size() {
        return queue.size();
    }

    // Print the buffer contents
    public void printBuffer() {
        System.out.println("Buffer: " + queue);
    }
}

public class BufferUsingQueue {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3); // Create a circular buffer of size 3

        buffer.add(10);
        buffer.add(20);
        buffer.add(30);
        buffer.printBuffer();

        buffer.add(40);
        buffer.printBuffer();

        System.out.println("Removed: " + buffer.remove());
        buffer.printBuffer();

        buffer.add(50);
        buffer.printBuffer();
    }
}
