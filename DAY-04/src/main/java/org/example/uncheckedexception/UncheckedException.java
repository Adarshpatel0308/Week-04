package org.example.uncheckedexception;

import java.util.Scanner;

public class UncheckedException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            // Asking the user to enter two numbers
            System.out.println("Enter the first number: ");
            int num1 = input.nextInt();

            System.out.println("Enter the second number: ");
            int num2 = input.nextInt();

            // Performing division and printing the result
            int result = num1 / num2;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Handling division by zero
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
            // Handling non-numeric input
            System.out.println("Error: Please enter a valid numeric value.");
        } finally {
            input.close();  // Closing the Scanner
            System.out.println("Program execution completed.");
        }
    }
}
