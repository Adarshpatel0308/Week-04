package org.example.queueinterface.implements_stackusingqueues;

import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // Constructor
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push operation
    public void push(int x) {
        // Add the new element to queue2
        queue2.add(x);

        // Move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        // Swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return queue1.poll();
    }

    // Top operation
    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return queue1.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class ImplementStack {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Top element after pop: " + stack.top()); // Output: 20
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
    }
}
