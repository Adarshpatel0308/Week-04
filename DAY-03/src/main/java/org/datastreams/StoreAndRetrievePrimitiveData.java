package org.datastreams;

import java.io.*;

    class Student {
        int rollNumber;
        String name;
        double gpa;

        // Constructor
        public Student(int rollNumber, String name, double gpa) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.gpa = gpa;
        }

        // Override toString() for better output representation
        @Override
        public String toString() {
            return "Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa;
        }
    }

    public class StoreAndRetrievePrimitiveData {
        public static void main(String[] args) {
            // File path for storing student data
            String filePath = "src/main/java/org/datastreams/BinaryFile.txt";

            // Create a student object
            Student student = new Student(101, "John Doe", 3.8);

            // Write student data to a binary file
            try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath))) {
                // Write student details to the file
                dataOutputStream.writeInt(student.rollNumber);
                dataOutputStream.writeUTF(student.name); // UTF for String
                dataOutputStream.writeDouble(student.gpa);

                System.out.println("Student data written to file successfully!");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }

            // Read student data from the binary file
            try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath))) {
                // Read student details from the file
                int rollNumber = dataInputStream.readInt();
                String name = dataInputStream.readUTF();
                double gpa = dataInputStream.readDouble();

                // Create a Student object with the retrieved data
                Student retrievedStudent = new Student(rollNumber, name, gpa);

                // Display the retrieved student details
                System.out.println("Retrieved Student Data: " + retrievedStudent);
            } catch (IOException e) {
                System.err.println("Error reading from file: " + e.getMessage());
            }
        }
    }
