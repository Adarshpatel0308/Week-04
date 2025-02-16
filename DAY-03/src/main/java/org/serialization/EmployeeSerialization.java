package org.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class must implement Serializable to allow object serialization
class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Override toString() to display employee details
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "IT", 60000));
        employees.add(new Employee(3, "Carol", "Finance", 55000));

        // File to store serialized data
        String fileName = "src/main/java/org/serialization/serializationAnddeseializaton.txt";

        // Serialize the list of employees to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employee list serialized and saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred during serialization: " + e.getMessage());
        }

        // Deserialize the list of employees from the file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("Employee list deserialized from " + fileName);
            deserializedEmployees.forEach(System.out::println); // Print each employee
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred during deserialization: " + e.getMessage());
        }
    }
}